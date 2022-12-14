package com.monsters.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.monsters.admin.model.dto.AdminRegisterDTO;
import com.monsters.admin.model.dto.UpdateAdminPasswordDTO;
import com.monsters.admin.repository.AdminInfoRepository;
import com.monsters.admin.security.domain.AdminUserDetails;
import com.monsters.admin.security.util.JwtTokenUtil;
import com.monsters.admin.security.util.SpringUtil;
import com.monsters.admin.service.AdminCacheService;
import com.monsters.admin.service.AdminRoleRelationService;
import com.monsters.admin.service.AdminService;
import com.monsters.admin.service.ResourceService;
import com.monsters.common.exception.Asserts;
import com.monsters.common.service.impl.BaseServiceImpl;
import com.monsters.admin.repository.LoginLogRepository;
import com.monsters.generationcodingcore.admin.*;
import com.monsters.generationcodingcore.admin.QAdmin;
import com.monsters.generationcodingcore.admin.QAdminRoleRelation;
import com.monsters.generationcodingcore.admin.QRole;
import com.monsters.generationcodingcore.admin.QRoleResourceRelation;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Monsters
 * @date 2022/9/14 5:43 PM
 */
@Service
@Slf4j
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminInfoRepository> implements AdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginLogRepository loginLogRepository;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private AdminRoleRelationService adminRoleRelationService;

    QRoleResourceRelation qRoleResourceRelation = QRoleResourceRelation.roleResourceRelation;

    QAdminRoleRelation qAdminRoleRelation = QAdminRoleRelation.adminRoleRelation;

    QAdmin qAdmin = QAdmin.admin;
    QRole qRole = QRole.role;

    @Override
    public Admin getAdminByUsername(String username) {
        // ?????????????????????
        Admin admin = getCacheService().getAdmin(username);
        if (admin != null) return admin;
        List<Admin> adminList = this.getAdminListByName(username);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            // ????????????
            getCacheService().setAdmin(admin);
            return admin;
        }
        return null;
    }

    @Override
    public Admin register(AdminRegisterDTO adminRegisterDTO) {

        Admin admin = new Admin();
        BeanUtils.copyProperties(adminRegisterDTO, admin);
        admin.setStatus(1);
        //???????????????????????????????????????
        List<Admin> adminList = this.getAdminListByName(admin.getUsername());
        if (adminList.size() > 0) {
            return null;
        }
        //???????????????????????????
        String encodePassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
        return this.insert(admin);
    }


    @Override
    public String login(String username, String password) {
        String token = null;
        //????????????????????????????????????
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                Asserts.fail("???????????????");
            }
            if (!userDetails.isEnabled()) {
                Asserts.fail("??????????????????");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.warn("????????????:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public Page<Admin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageRequest request = PageRequest.of(pageNum - 1, pageSize);
        BooleanBuilder builder = new BooleanBuilder();
        if (StrUtil.isNotEmpty(keyword)){
            builder.and(qAdmin.username.like(keyword))
                    .or(qAdmin.nickName.like(keyword));
        }
        JPAQuery<Admin> jpaQuery = queryFactory.select(qAdmin).from(qAdmin);
        QueryResults<Admin> queryResults = jpaQuery.where(builder)
                .orderBy(qAdmin.id.desc())
                .offset(request.getOffset())
                .limit(request.getPageSize())
                .fetchResults();
        return new PageImpl<>(queryResults.getResults(), request, queryResults.getTotal());
    }


    @Override
    public Admin update(Admin entity) {
        Admin oldAdmin = this.getById(entity.getId());
        // ????????????????????????
        if (!oldAdmin.getPassword().equals(entity.getPassword())) {
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        }
        Admin result = super.update(entity);
        getCacheService().delAdmin(entity.getId());
        return result;
    }

    @Override
    public boolean delete(Long id) {
        getCacheService().delAdmin(id);
        this.deleteById(id);
        getCacheService().delResourceList(id);
        return true;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //????????????????????????
        adminRoleRelationService.move(adminId);
        //???????????????
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<AdminRoleRelation> relationList = new ArrayList<>();
            for (Long roleId : roleIds) {
                AdminRoleRelation roleRelation = new AdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                relationList.add(roleRelation);
            }
            adminRoleRelationService.saveBatch(relationList);
            getCacheService().delResourceList(adminId);
        }
        return count;
    }

    @Override
    public List<Role> getRoleList(Long adminId) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qAdminRoleRelation.adminId.eq(qRole.id))
                .and(qAdminRoleRelation.adminId.eq(adminId));
        return this.queryFactory
                .select(qRole)
                .from(qRole, qAdminRoleRelation)
                .where(builder)
                .fetch();
    }

    @Override
    public List<Resource> getResourceList(Long adminId) {
        List<Resource> resourceList = getCacheService().getResourceList(adminId);
        if (CollUtil.isNotEmpty(resourceList)) {
            return resourceList;
        }
        resourceList = this.resourceService.getResourceList(adminId);
        if (CollUtil.isNotEmpty(resourceList)) {
            getCacheService().setResourceList(adminId, resourceList);
        }
        return resourceList;
    }

    @Override
    public int updatePassword(UpdateAdminPasswordDTO param) {
        if (StrUtil.isEmpty(param.getUsername())
                || StrUtil.isEmpty(param.getOldPassword())
                || StrUtil.isEmpty(param.getNewPassword())) {
            return -1;
        }
        List<Admin> adminList = this.queryFactory.select(qAdmin).from(qAdmin).where(qAdmin.username.eq(param.getUsername())).fetch();
        if(CollUtil.isEmpty(adminList)){
            return -2;
        }
        Admin admin = adminList.get(0);
        if(!passwordEncoder.matches(param.getOldPassword(),admin.getPassword())){
            return -3;
        }
        admin.setPassword(passwordEncoder.encode(param.getNewPassword()));
        update(admin);
        getCacheService().delAdmin(admin.getId());
        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Admin admin = this.getAdminByUsername(username);
        if (admin != null) {
            List<Resource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin, resourceList);
        }
        throw new UsernameNotFoundException("????????????????????????");
    }


    @Override
    public AdminCacheService getCacheService() {
        return SpringUtil.getBean(AdminCacheService.class);
    }

    @Override
    public List<Long> getAdminIdList(Long resourceId) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder
                .and(qRoleResourceRelation.roleId.eq(qAdminRoleRelation.roleId))
                .and(qRoleResourceRelation.resourceId.eq(resourceId));

        return this.queryFactory
                .from(qRoleResourceRelation, qAdminRoleRelation)
                .select(qAdminRoleRelation.adminId)
                .where(booleanBuilder)
                .fetch();
    }


    /**
     * ??????????????????
     *
     * @param username ?????????
     */
    private void insertLoginLog(String username) {
        Admin admin = getAdminByUsername(username);
        if (admin == null) {
            return;
        }
        AdminLoginLog loginLog = new AdminLoginLog();
        loginLog.setAdminId(admin.getId());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogRepository.save(loginLog);
    }

    /**
     * ?????? username ????????????
     */
    private List<Admin> getAdminListByName(String username) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qAdmin.username.eq(username));
        return queryFactory.from(qAdmin).select(qAdmin).where(booleanBuilder).fetch();
    }
}

package com.monsters.generationcodingadmin.modules.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.monsters.generationcodingadmin.common.exception.Asserts;
import com.monsters.generationcodingadmin.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingadmin.domain.AdminUserDetails;
import com.monsters.generationcodingadmin.modules.admin.entity.*;
import com.monsters.generationcodingadmin.modules.admin.entity.QAdmin;
import com.monsters.generationcodingadmin.modules.admin.entity.QAdminRoleRelation;
import com.monsters.generationcodingadmin.modules.admin.entity.QRole;
import com.monsters.generationcodingadmin.modules.admin.entity.QRoleResourceRelation;
import com.monsters.generationcodingadmin.modules.admin.model.dto.AdminRegisterDTO;
import com.monsters.generationcodingadmin.modules.admin.model.dto.UpdateAdminPasswordDTO;
import com.monsters.generationcodingadmin.modules.admin.repository.AdminInfoRepository;
import com.monsters.generationcodingadmin.modules.admin.repository.LoginLogRepository;
import com.monsters.generationcodingadmin.modules.admin.service.AdminCacheService;
import com.monsters.generationcodingadmin.modules.admin.service.AdminRoleRelationService;
import com.monsters.generationcodingadmin.modules.admin.service.AdminService;
import com.monsters.generationcodingadmin.modules.admin.service.ResourceService;
import com.monsters.generationcodingadmin.security.util.JwtTokenUtil;
import com.monsters.generationcodingadmin.security.util.SpringUtil;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
        // 先从缓存里面找
        Admin admin = getCacheService().getAdmin(username);
        if (admin != null) return admin;
        List<Admin> adminList = this.getAdminListByName(username);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            // 更新缓存
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
        //查询是否有相同用户名的用户
        List<Admin> adminList = this.getAdminListByName(admin.getUsername());
        if (adminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
        return this.insert(admin);
    }


    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                Asserts.fail("密码不正确");
            }
            if (!userDetails.isEnabled()) {
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
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
        // 修改密码需要加密
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
        //先删除原来的关系
        adminRoleRelationService.move(adminId);
        //建立新关系
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
        //TODO
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
        throw new UsernameNotFoundException("用户名或密码错误");
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
     * 添加登录记录
     *
     * @param username 用户名
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
     * 通过 username 查询用户
     */
    private List<Admin> getAdminListByName(String username) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qAdmin.username.eq(username));
        return queryFactory.from(qAdmin).select(qAdmin).where(booleanBuilder).fetch();
    }
}

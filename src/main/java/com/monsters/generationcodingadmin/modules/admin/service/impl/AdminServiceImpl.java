package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingadmin.modules.admin.entity.*;
import com.monsters.generationcodingadmin.modules.admin.entity.QAdminRoleRelation;
import com.monsters.generationcodingadmin.modules.admin.entity.QRoleResourceRelation;
import com.monsters.generationcodingadmin.modules.admin.model.dto.AdminRegisterDTO;
import com.monsters.generationcodingadmin.modules.admin.model.dto.UpdateAdminPasswordDTO;
import com.monsters.generationcodingadmin.modules.admin.repository.AdminInfoRepository;
import com.monsters.generationcodingadmin.modules.admin.service.AdminCacheService;
import com.monsters.generationcodingadmin.modules.admin.service.AdminService;
import com.monsters.generationcodingadmin.security.util.JwtTokenUtil;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/9/14 5:43 PM
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminInfoRepository> implements AdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    QRoleResourceRelation qRoleResourceRelation = QRoleResourceRelation.roleResourceRelation;

    QAdminRoleRelation qAdminRoleRelation = QAdminRoleRelation.adminRoleRelation;


    @Override
    public Admin getAdminByUsername(String name) {
        //        TODO
        return null;
    }

    @Override
    public Admin register(AdminRegisterDTO adminRegisterDTO) {
        //        TODO

        return null;
    }

    @Override
    public String login(String username, String password) {
        //        TODO

        return null;
    }

    @Override
    public String refreshToken(String oldToken) {
//        TODO
        return null;
    }

    @Override
    public Page<Admin> list(String keyword, Integer pageSize, Integer pageNum) {
//        TODO
        return null;
    }

    @Override
    public boolean update(Long id, Admin admin) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(Long id) {
        //TODO
        return false;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
//        TODO
        return 0;
    }

    @Override
    public List<Role> getRoleList(Long adminId) {
        //TODO
        return null;
    }

    @Override
    public List<Resource> getResourceList(Long adminId) {
        //TODO
        return null;
    }

    @Override
    public int updatePassword(UpdateAdminPasswordDTO updatePasswordParam) {
        //TODO
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //TODO
        return null;
    }

    @Override
    public Admin getById(Long adminId) {
        return null;
    }

    @Override
    public AdminCacheService getCacheService() {
        return null;
    }

    @Override
    public List<Long> getAdminIdList(Long resourceId) {

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qRoleResourceRelation.roleId.eq(qAdminRoleRelation.roleId))
                .and(qRoleResourceRelation.resourceId.eq(resourceId));

        this.queryFactory
                .from(qRoleResourceRelation, qAdminRoleRelation)
                .select(qAdminRoleRelation.adminId)
                .where(booleanBuilder)
                .fetch();

        return null;
    }
}

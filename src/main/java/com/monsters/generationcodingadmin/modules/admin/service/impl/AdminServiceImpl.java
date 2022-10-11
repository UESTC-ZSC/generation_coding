package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.modules.admin.entity.Admin;
import com.monsters.generationcodingadmin.modules.admin.entity.Resource;
import com.monsters.generationcodingadmin.modules.admin.entity.Role;
import com.monsters.generationcodingadmin.modules.admin.model.dto.AdminRegisterDTO;
import com.monsters.generationcodingadmin.modules.admin.model.dto.UpdateAdminPasswordDTO;
import com.monsters.generationcodingadmin.modules.admin.repository.AdminInfoRepository;
import com.monsters.generationcodingadmin.modules.admin.service.AdminCacheService;
import com.monsters.generationcodingadmin.modules.admin.service.AdminService;
import com.monsters.generationcodingadmin.security.util.JwtTokenUtil;
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
public class AdminServiceImpl implements AdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;


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
}

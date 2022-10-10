package com.monsters.generationcodingadmin.modules.admin.service;

import com.monsters.generationcodingadmin.modules.admin.entity.Admin;
import com.monsters.generationcodingadmin.modules.admin.entity.Resource;
import com.monsters.generationcodingadmin.modules.admin.entity.Role;
import com.monsters.generationcodingadmin.modules.admin.model.dto.AdminRegisterDTO;
import com.monsters.generationcodingadmin.modules.admin.model.dto.UpdateAdminPasswordDTO;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台管理员 service
 * @author Monsters
 * @date 2022/9/14 5:42 PM
 */
public interface AdminService {

    /**
     * 根据名称查询管理员
     */
    Admin getAdminByUsername(String name);

    /**
     * 注册
     */
    Admin register(AdminRegisterDTO adminRegisterDTO);

    /**
     * 登陆
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户名或昵称分页查询用户
     */
    Page<Admin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 更新用户
     */
    boolean update(Long id, Admin admin);

    /**
     * 删除用户
     */
    boolean delete(Long id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     */
    List<Role> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     */
    List<Resource> getResourceList(Long adminId);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordDTO updatePasswordParam);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 通过 id 获取用户
     */
    Admin getById(Long adminId);

    /**
     * 获取缓存服务
     */
    AdminCacheService getCacheService();


}

package com.monsters.generationcodingadmin.modules.admin.service;

import com.monsters.generationcodingadmin.modules.admin.entity.Menu;
import com.monsters.generationcodingadmin.modules.admin.entity.Resource;
import com.monsters.generationcodingadmin.modules.admin.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/10 9:59 PM
 */
public interface RoleService {

    /**
     * 添加角色
     */
    boolean create(Role role);

    /**
     * 批量删除角色
     */
    boolean delete(List<Long> ids);

    /**
     * 分页获取角色列表
     */
    Page<Role> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<Menu> getMenuList(Long adminId);

    /**
     * 获取角色相关菜单
     */
    List<Menu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     */
    List<Resource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}

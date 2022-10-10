package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.modules.admin.entity.Menu;
import com.monsters.generationcodingadmin.modules.admin.entity.Resource;
import com.monsters.generationcodingadmin.modules.admin.entity.Role;
import com.monsters.generationcodingadmin.modules.admin.service.RoleService;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/10 10:00 PM
 */
public class RoleServiceImpl implements RoleService {
    @Override
    public boolean create(Role role) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(List<Long> ids) {
        //TODO
        return false;
    }

    @Override
    public Page<Role> list(String keyword, Integer pageSize, Integer pageNum) {
        //TODO
        return null;
    }

    @Override
    public List<Menu> getMenuList(Long adminId) {
        //TODO
        return null;
    }

    @Override
    public List<Menu> listMenu(Long roleId) {
        //TODO
        return null;
    }

    @Override
    public List<Resource> listResource(Long roleId) {
        //TODO
        return null;
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //TODO
        return 0;
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //TODO
        return 0;
    }
}

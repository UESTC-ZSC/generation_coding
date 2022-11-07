package com.monsters.generationcodingadmin.modules.admin.service;

import com.monsters.generationcodingadmin.common.service.BaseService;
import com.monsters.generationcodingadmin.modules.admin.entity.RoleMenuRelation;

/**
 * 角色菜单关系管理Service
 * @author Monsters
 * @date 2022/10/10 9:55 PM
 */
public interface RoleMenuRelationService extends BaseService<RoleMenuRelation> {

    /**
     * 删除原有的角色菜单关系
     */
    void remove(Long roleId);
}

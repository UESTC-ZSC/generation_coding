package com.monsters.admin.service;

import com.monsters.common.service.BaseService;
import com.monsters.generationcodingcore.admin.RoleResourceRelation;

/**
 * 角色资源关系管理Service
 *
 * @author Monsters
 * @date 2022/10/10 9:55 PM
 */
public interface RoleResourceRelationService extends BaseService<RoleResourceRelation> {

    /**
     * 删除角色资源关系
     */
    void remove(Long roleId);
}

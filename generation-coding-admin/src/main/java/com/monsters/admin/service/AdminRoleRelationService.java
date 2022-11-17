package com.monsters.admin.service;

import com.monsters.common.service.BaseService;
import com.monsters.generationcodingcore.admin.AdminRoleRelation;

import java.util.List;

/**
 * 管理员角色关系管理Service
 * @author Monsters
 * @date 2022/10/10 5:02 PM
 */
public interface AdminRoleRelationService extends BaseService<AdminRoleRelation> {

    List<AdminRoleRelation> list(Long roleId);

    List<AdminRoleRelation> list(List<Long> roleIds);

    void move(Long adminId);
}

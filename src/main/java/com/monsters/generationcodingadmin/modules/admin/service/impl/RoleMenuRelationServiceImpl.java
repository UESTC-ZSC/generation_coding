package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingadmin.modules.admin.entity.QRoleMenuRelation;
import com.monsters.generationcodingadmin.modules.admin.entity.RoleMenuRelation;
import com.monsters.generationcodingadmin.modules.admin.repository.RoleMenuRelationInfoRepository;
import com.monsters.generationcodingadmin.modules.admin.service.RoleMenuRelationService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;

/**
 * @author Monsters
 * @date 2022/10/10 9:58 PM
 */
@Service
public class RoleMenuRelationServiceImpl extends BaseServiceImpl<RoleMenuRelation, RoleMenuRelationInfoRepository> implements RoleMenuRelationService {

    QRoleMenuRelation qRoleMenuRelation = QRoleMenuRelation.roleMenuRelation;

    @Override
    public void remove(Long roleId) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qRoleMenuRelation.roleId.eq(roleId));
        this.queryFactory.delete(qRoleMenuRelation).where(builder).execute();
    }
}

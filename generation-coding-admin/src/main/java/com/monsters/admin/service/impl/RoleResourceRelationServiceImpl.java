package com.monsters.admin.service.impl;

import com.monsters.generationcodingcore.admin.QRoleResourceRelation;
import com.monsters.generationcodingcore.admin.RoleResourceRelation;
import com.monsters.admin.repository.RoleResourceRelationInfoRepository;
import com.monsters.common.service.impl.BaseServiceImpl;
import com.monsters.admin.service.RoleResourceRelationService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;

/**
 * @author Monsters
 * @date 2022/10/10 9:58 PM
 */
@Service
public class RoleResourceRelationServiceImpl extends BaseServiceImpl<RoleResourceRelation, RoleResourceRelationInfoRepository> implements RoleResourceRelationService {

    QRoleResourceRelation qRoleResourceRelation = QRoleResourceRelation.roleResourceRelation;


    @Override
    public void remove(Long roleId) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qRoleResourceRelation.resourceId.eq(roleId));
        this.queryFactory.delete(qRoleResourceRelation).where(builder).execute();
    }
}

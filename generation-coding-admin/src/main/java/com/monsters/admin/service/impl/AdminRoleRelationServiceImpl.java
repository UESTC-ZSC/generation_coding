package com.monsters.admin.service.impl;

import com.monsters.generationcodingcore.admin.AdminRoleRelation;
import com.monsters.admin.repository.AdminRoleRelationRepository;
import com.monsters.admin.service.AdminRoleRelationService;
import com.monsters.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingcore.admin.QAdminRoleRelation;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/10 5:04 PM
 */
@Service
public class AdminRoleRelationServiceImpl extends BaseServiceImpl<AdminRoleRelation, AdminRoleRelationRepository> implements AdminRoleRelationService {

    QAdminRoleRelation qAdminRoleRelation = QAdminRoleRelation.adminRoleRelation;


    @Override
    public List<AdminRoleRelation> list(Long roleId) {
        Predicate predicate = qAdminRoleRelation.roleId.eq(roleId);
        return this.queryFactory
                .from(qAdminRoleRelation)
                .select(qAdminRoleRelation)
                .where(predicate)
                .fetch();
    }

    @Override
    public List<AdminRoleRelation> list(List<Long> roleIds) {
        Predicate predicate = qAdminRoleRelation.roleId.in(roleIds);
        return this.queryFactory
                .from(qAdminRoleRelation)
                .select(qAdminRoleRelation)
                .where(predicate)
                .fetch();
    }

    @Override
    public void move(Long adminId) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qAdminRoleRelation.adminId.eq(adminId));
        this.queryFactory.delete(qAdminRoleRelation).where(builder);
    }
}

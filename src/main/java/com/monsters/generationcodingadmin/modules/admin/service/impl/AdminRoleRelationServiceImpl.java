package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingadmin.modules.admin.entity.AdminRoleRelation;
import com.monsters.generationcodingadmin.modules.admin.entity.QAdminRoleRelation;
import com.monsters.generationcodingadmin.modules.admin.repository.AdminRoleRelationRepository;
import com.monsters.generationcodingadmin.modules.admin.service.AdminRoleRelationService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
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

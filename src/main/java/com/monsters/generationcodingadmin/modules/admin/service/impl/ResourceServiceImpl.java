package com.monsters.generationcodingadmin.modules.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.monsters.generationcodingadmin.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingadmin.modules.admin.entity.*;
import com.monsters.generationcodingadmin.modules.admin.entity.QAdminRoleRelation;
import com.monsters.generationcodingadmin.modules.admin.entity.QResource;
import com.monsters.generationcodingadmin.modules.admin.entity.QRole;
import com.monsters.generationcodingadmin.modules.admin.entity.QRoleResourceRelation;
import com.monsters.generationcodingadmin.modules.admin.repository.ResourceInfoRepository;
import com.monsters.generationcodingadmin.modules.admin.service.ResourceService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/9 11:32 PM
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, ResourceInfoRepository> implements ResourceService {

    QRole qRole = QRole.role;

    QResource qResource = QResource.resource;

    QAdminRoleRelation qAdminRoleRelation = QAdminRoleRelation.adminRoleRelation;

    QRoleResourceRelation qRoleResourceRelation = QRoleResourceRelation.roleResourceRelation;



    @Override
    public Page<Resource> list(Long id, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageRequest request = PageRequest.of(pageNum - 1, pageSize);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (id != null){
            booleanBuilder.and(qResource.id.eq(id));
        }
        if (StrUtil.isNotEmpty(nameKeyword)){
            booleanBuilder.and(qResource.name.like(nameKeyword));
        }
        if (StrUtil.isNotEmpty(urlKeyword)){
            booleanBuilder.and(qResource.url.like(urlKeyword));
        }
        JPAQuery<Resource> jpaQuery = queryFactory.select(qResource).from(qResource);
        QueryResults<Resource> queryResults = jpaQuery.where(booleanBuilder)
                .orderBy(qResource.id.desc())
                .offset(request.getOffset())
                .limit(request.getPageSize())
                .fetchResults();
        return new PageImpl<>(queryResults.getResults(),request, queryResults.getTotal());
    }


    @Override
    public List<Resource> getResourceList(Long adminId) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder
                .and(qAdminRoleRelation.roleId.eq(qRole.id))
                .and(qRoleResourceRelation.roleId.eq(qRole.id))
                .and(qRoleResourceRelation.resourceId.eq(qResource.id))
                .and(qAdminRoleRelation.adminId.eq(adminId))
                .and(qResource.id.isNotNull());
        return this.queryFactory
                .from(qResource, qAdminRoleRelation, qRoleResourceRelation, qRole)
                .select(qResource)
                .where(booleanBuilder)
                .groupBy(qResource.id).fetch();
    }
}

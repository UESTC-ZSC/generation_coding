package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingadmin.modules.admin.entity.*;
import com.monsters.generationcodingadmin.modules.admin.entity.QAdminRoleRelation;
import com.monsters.generationcodingadmin.modules.admin.entity.QResource;
import com.monsters.generationcodingadmin.modules.admin.entity.QRole;
import com.monsters.generationcodingadmin.modules.admin.entity.QRoleResourceRelation;
import com.monsters.generationcodingadmin.modules.admin.repository.ResourceInfoRepository;
import com.monsters.generationcodingadmin.modules.admin.service.ResourceService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
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
    public boolean create(Resource umsResource) {
        //TODO
        return false;
    }

    @Override
    public boolean update(Long id, Resource umsResource) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(Long id) {
        //TODO
        return false;
    }

    @Override
    public Page<Resource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        //TODO
        return null;
    }

    @Override
    public List<Resource> list() {
        //TODO
        Resource resource = new Resource();
        resource.setName("菜单");
        resource.setUrl("/menu");
        resource.setDescription("菜单");
        resource.setCategoryId(1L);
        List<Resource> list = new ArrayList<>();
        list.add(resource);
        return list;
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

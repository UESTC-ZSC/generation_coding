package com.monsters.generationcodingadmin.modules.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.monsters.generationcodingadmin.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingadmin.modules.admin.entity.*;
import com.monsters.generationcodingadmin.modules.admin.entity.QAdminRoleRelation;
import com.monsters.generationcodingadmin.modules.admin.entity.QMenu;
import com.monsters.generationcodingadmin.modules.admin.entity.QResource;
import com.monsters.generationcodingadmin.modules.admin.entity.QRole;
import com.monsters.generationcodingadmin.modules.admin.entity.QRoleMenuRelation;
import com.monsters.generationcodingadmin.modules.admin.entity.QRoleResourceRelation;
import com.monsters.generationcodingadmin.modules.admin.repository.RoleInfoRepository;
import com.monsters.generationcodingadmin.modules.admin.service.RoleService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/10 10:00 PM
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleInfoRepository> implements RoleService {

    QRole qRole = QRole.role;

    QAdminRoleRelation qAdminRoleRelation = QAdminRoleRelation.adminRoleRelation;

    QRoleMenuRelation qRoleMenuRelation = QRoleMenuRelation.roleMenuRelation;

    QMenu qMenu = QMenu.menu;

    QResource qResource = QResource.resource;

    QRoleResourceRelation qRoleResourceRelation = QRoleResourceRelation.roleResourceRelation;

    @Override
    public Page<Role> list(String keyword, Integer pageSize, Integer pageNum) {
        PageRequest request = PageRequest.of(pageNum - 1, pageSize);
        BooleanBuilder builder = new BooleanBuilder();

        if (StrUtil.isNotEmpty(keyword)) {
            builder.and(qRole.name.like(keyword));
        }
        QueryResults<Role> queryResults = this.queryFactory
                .select(qRole)
                .from(qRole)
                .where(builder)
                .offset(request.getOffset())
                .limit(request.getPageSize())
                .fetchResults();
        return new PageImpl<>(queryResults.getResults(), request, queryResults.getTotal());
    }

    @Override
    public List<Menu> getMenuList(Long adminId) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qRole.id.eq(qAdminRoleRelation.adminId))
                .and(qRoleMenuRelation.roleId.eq(qRole.id))
                .and(qMenu.id.eq(qRoleMenuRelation.menuId))
                .and(qAdminRoleRelation.adminId.eq(adminId))
                .and(qMenu.id.isNotNull());

        return this.queryFactory
                .select(qMenu)
                .from(qMenu, qRole, qAdminRoleRelation, qRoleMenuRelation)
                .where(builder)
                .groupBy(qMenu.id)
                .fetch();
    }

    @Override
    public List<Menu> listMenu(Long roleId) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qMenu.id.eq(qRoleMenuRelation.menuId))
                .and(qRoleMenuRelation.roleId.eq(roleId))
                .and(qMenu.id.isNotNull());
        return this.queryFactory
                .select(qMenu)
                .from(qMenu, qRoleMenuRelation)
                .where(builder)
                .groupBy(qMenu.id)
                .fetch();
    }

    @Override
    public List<Resource> listResource(Long roleId) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qResource.id.eq(qRoleResourceRelation.resourceId))
                .and(qRoleResourceRelation.roleId.eq(roleId))
                .and(qResource.id.isNotNull());
        return this.queryFactory
                .select(qResource)
                .select(qResource)
                .where(builder)
                .groupBy(qResource.id)
                .fetch();
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

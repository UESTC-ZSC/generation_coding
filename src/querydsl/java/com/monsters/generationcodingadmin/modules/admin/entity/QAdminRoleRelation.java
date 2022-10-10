package com.monsters.generationcodingadmin.modules.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminRoleRelation is a Querydsl query type for AdminRoleRelation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminRoleRelation extends EntityPathBase<AdminRoleRelation> {

    private static final long serialVersionUID = -804535451L;

    public static final QAdminRoleRelation adminRoleRelation = new QAdminRoleRelation("adminRoleRelation");

    public final com.monsters.generationcodingadmin.common.entity.QBaseEntity _super = new com.monsters.generationcodingadmin.common.entity.QBaseEntity(this);

    public final NumberPath<Long> adminId = createNumber("adminId", Long.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QAdminRoleRelation(String variable) {
        super(AdminRoleRelation.class, forVariable(variable));
    }

    public QAdminRoleRelation(Path<? extends AdminRoleRelation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminRoleRelation(PathMetadata metadata) {
        super(AdminRoleRelation.class, metadata);
    }

}


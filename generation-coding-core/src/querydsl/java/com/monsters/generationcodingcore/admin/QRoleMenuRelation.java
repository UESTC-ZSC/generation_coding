package com.monsters.generationcodingcore.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoleMenuRelation is a Querydsl query type for RoleMenuRelation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoleMenuRelation extends EntityPathBase<RoleMenuRelation> {

    private static final long serialVersionUID = 910054421L;

    public static final QRoleMenuRelation roleMenuRelation = new QRoleMenuRelation("roleMenuRelation");

    public final com.monsters.common.entity.QBaseEntity _super = new com.monsters.common.entity.QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> menuId = createNumber("menuId", Long.class);

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QRoleMenuRelation(String variable) {
        super(RoleMenuRelation.class, forVariable(variable));
    }

    public QRoleMenuRelation(Path<? extends RoleMenuRelation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoleMenuRelation(PathMetadata metadata) {
        super(RoleMenuRelation.class, metadata);
    }

}


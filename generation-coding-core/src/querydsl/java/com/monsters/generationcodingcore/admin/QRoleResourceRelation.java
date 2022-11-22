package com.monsters.generationcodingcore.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoleResourceRelation is a Querydsl query type for RoleResourceRelation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoleResourceRelation extends EntityPathBase<RoleResourceRelation> {

    private static final long serialVersionUID = 1954252484L;

    public static final QRoleResourceRelation roleResourceRelation = new QRoleResourceRelation("roleResourceRelation");

    public final com.monsters.common.entity.QBaseEntity _super = new com.monsters.common.entity.QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> resourceId = createNumber("resourceId", Long.class);

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QRoleResourceRelation(String variable) {
        super(RoleResourceRelation.class, forVariable(variable));
    }

    public QRoleResourceRelation(Path<? extends RoleResourceRelation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoleResourceRelation(PathMetadata metadata) {
        super(RoleResourceRelation.class, metadata);
    }

}


package com.monsters.generationcodingadmin.modules.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = -2041619438L;

    public static final QRole role = new QRole("role");

    public final com.monsters.generationcodingadmin.common.entity.QHasCreateEntity _super = new com.monsters.generationcodingadmin.common.entity.QHasCreateEntity(this);

    public final NumberPath<Integer> adminCount = createNumber("adminCount", Integer.class);

    //inherited
    public final StringPath createBy = _super.createBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTime = _super.createTime;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    //inherited
    public final StringPath updateBy = _super.updateBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}


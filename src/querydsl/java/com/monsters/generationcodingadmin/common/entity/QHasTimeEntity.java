package com.monsters.generationcodingadmin.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHasTimeEntity is a Querydsl query type for HasTimeEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QHasTimeEntity extends EntityPathBase<HasTimeEntity> {

    private static final long serialVersionUID = -1208117799L;

    public static final QHasTimeEntity hasTimeEntity = new QHasTimeEntity("hasTimeEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QHasTimeEntity(String variable) {
        super(HasTimeEntity.class, forVariable(variable));
    }

    public QHasTimeEntity(Path<? extends HasTimeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHasTimeEntity(PathMetadata metadata) {
        super(HasTimeEntity.class, metadata);
    }

}


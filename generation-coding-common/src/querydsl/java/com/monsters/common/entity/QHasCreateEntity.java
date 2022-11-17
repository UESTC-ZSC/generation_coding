package com.monsters.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHasCreateEntity is a Querydsl query type for HasCreateEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QHasCreateEntity extends EntityPathBase<HasCreateEntity> {

    private static final long serialVersionUID = 28607657L;

    public static final QHasCreateEntity hasCreateEntity = new QHasCreateEntity("hasCreateEntity");

    public final QHasTimeEntity _super = new QHasTimeEntity(this);

    public final StringPath createBy = createString("createBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTime = _super.createTime;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath updateBy = createString("updateBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QHasCreateEntity(String variable) {
        super(HasCreateEntity.class, forVariable(variable));
    }

    public QHasCreateEntity(Path<? extends HasCreateEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHasCreateEntity(PathMetadata metadata) {
        super(HasCreateEntity.class, metadata);
    }

}


package com.monsters.generationcodingcore.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QResourceAllocation is a Querydsl query type for ResourceAllocation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResourceAllocation extends EntityPathBase<ResourceAllocation> {

    private static final long serialVersionUID = -2022923630L;

    public static final QResourceAllocation resourceAllocation = new QResourceAllocation("resourceAllocation");

    public final com.monsters.common.entity.QHasTimeEntity _super = new com.monsters.common.entity.QHasTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTime = _super.createTime;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> sort = createNumber("sort", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QResourceAllocation(String variable) {
        super(ResourceAllocation.class, forVariable(variable));
    }

    public QResourceAllocation(Path<? extends ResourceAllocation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResourceAllocation(PathMetadata metadata) {
        super(ResourceAllocation.class, metadata);
    }

}


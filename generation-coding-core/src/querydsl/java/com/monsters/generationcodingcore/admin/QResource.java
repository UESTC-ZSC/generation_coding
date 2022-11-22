package com.monsters.generationcodingcore.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QResource is a Querydsl query type for Resource
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResource extends EntityPathBase<Resource> {

    private static final long serialVersionUID = 1062265874L;

    public static final QResource resource = new QResource("resource");

    public final com.monsters.common.entity.QHasTimeEntity _super = new com.monsters.common.entity.QHasTimeEntity(this);

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTime = _super.createTime;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public final StringPath url = createString("url");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QResource(String variable) {
        super(Resource.class, forVariable(variable));
    }

    public QResource(Path<? extends Resource> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResource(PathMetadata metadata) {
        super(Resource.class, metadata);
    }

}


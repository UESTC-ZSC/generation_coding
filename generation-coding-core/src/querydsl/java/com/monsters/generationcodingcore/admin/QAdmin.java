package com.monsters.generationcodingcore.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdmin is a Querydsl query type for Admin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdmin extends EntityPathBase<Admin> {

    private static final long serialVersionUID = -1927249461L;

    public static final QAdmin admin = new QAdmin("admin");

    public final com.monsters.common.entity.QHasCreateEntity _super = new com.monsters.common.entity.QHasCreateEntity(this);

    //inherited
    public final StringPath createBy = _super.createBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTime = _super.createTime;

    public final StringPath email = createString("email");

    public final StringPath icon = createString("icon");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.util.Date> loginTime = createDateTime("loginTime", java.util.Date.class);

    public final StringPath nickName = createString("nickName");

    public final StringPath note = createString("note");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    //inherited
    public final StringPath updateBy = _super.updateBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public final StringPath username = createString("username");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QAdmin(String variable) {
        super(Admin.class, forVariable(variable));
    }

    public QAdmin(Path<? extends Admin> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdmin(PathMetadata metadata) {
        super(Admin.class, metadata);
    }

}


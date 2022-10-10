package com.monsters.generationcodingadmin.modules.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminLoginLog is a Querydsl query type for AdminLoginLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminLoginLog extends EntityPathBase<AdminLoginLog> {

    private static final long serialVersionUID = 552186734L;

    public static final QAdminLoginLog adminLoginLog = new QAdminLoginLog("adminLoginLog");

    public final com.monsters.generationcodingadmin.common.entity.QHasTimeEntity _super = new com.monsters.generationcodingadmin.common.entity.QHasTimeEntity(this);

    public final StringPath address = createString("address");

    public final NumberPath<Long> adminId = createNumber("adminId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTime = _super.createTime;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath ip = createString("ip");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public final StringPath userAgent = createString("userAgent");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QAdminLoginLog(String variable) {
        super(AdminLoginLog.class, forVariable(variable));
    }

    public QAdminLoginLog(Path<? extends AdminLoginLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminLoginLog(PathMetadata metadata) {
        super(AdminLoginLog.class, metadata);
    }

}


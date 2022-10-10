package com.monsters.generationcodingadmin.common.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 带创建时间的基础实体
 *
 * @author Monsters
 * @date 2022/9/10 4:29 PM
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class HasTimeEntity extends BaseEntity{

    // 创建时间
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createTime;

    // 修改时间
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateTime;
}
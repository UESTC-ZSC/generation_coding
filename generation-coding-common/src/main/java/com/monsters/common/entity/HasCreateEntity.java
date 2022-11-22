package com.monsters.common.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * 带创建人的基础实体
 *
 * @author Monsters
 * @date 2022/9/10 4:29 PM
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class HasCreateEntity extends HasTimeEntity{

    // 创建着名称
    @CreatedBy
    @Column(nullable = false)
    private String createBy;

    // 修改者名称
    @LastModifiedBy
    @Column(nullable = false)
    private String updateBy;
}

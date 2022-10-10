package com.monsters.generationcodingadmin.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 基础实体类
 * @author Monsters
 * @date 2022/9/10 4:26 PM
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @ApiModelProperty("主键ID")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty("版本号")
    private long version;
}

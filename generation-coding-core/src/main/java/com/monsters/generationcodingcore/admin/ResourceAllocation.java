package com.monsters.generationcodingcore.admin;

import com.monsters.common.entity.HasTimeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 资源分类表
 *
 * @author Monsters
 * @date 2022/9/10 5:05 PM
 */
@Data
@Entity
@ApiModel(value = "ResourceAllocation对象", description = "资源分类表")
public class ResourceAllocation extends HasTimeEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}

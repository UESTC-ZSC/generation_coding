package com.monsters.generationcodingadmin.modules.admin.entity;

import com.monsters.generationcodingadmin.common.entity.HasTimeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

/**
 * 后台资源表
 *
 * @author Monsters
 * @date 2022/9/10 4:35 PM
 */
@Data
@Entity
@ApiModel(value = "Resource对象", description = "后台资源表")
public class Resource extends HasTimeEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源URL")
    private String url;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "资源分类ID")
    private Long categoryId;

}

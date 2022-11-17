package com.monsters.generationcodingcore.admin;

import com.monsters.common.entity.HasCreateEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 后台用户角色表
 *
 * @author Monsters
 * @date 2022/9/10 4:34 PM
 */
@Data
@Entity
@ApiModel(value = "Role对象", description = "后台用户角色表")
public class Role extends HasCreateEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "后台用户数量")
    private Integer adminCount;

    @ApiModelProperty(value = "启用状态：0->禁用；1->启用")
    private Integer status;

    private Integer sort;

}

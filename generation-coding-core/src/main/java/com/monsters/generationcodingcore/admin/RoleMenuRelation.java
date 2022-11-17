package com.monsters.generationcodingcore.admin;

import com.monsters.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 后台角色菜单关系表
 *
 * @author Monsters
 * @date 2022/9/10 5:12 PM
 */
@Data
@Entity
@ApiModel(value = "RoleMenuRelation对象", description = "后台角色菜单关系表")
public class RoleMenuRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "菜单ID")
    private Long menuId;
}

package com.monsters.generationcodingadmin.modules.admin.entity;

import com.monsters.generationcodingadmin.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 后台角色资源关系表
 *
 * @author Monsters
 * @date 2022/9/10 5:38 PM
 */
@Entity
@Data
@ApiModel(value="RoleResourceRelation对象", description="后台角色资源关系表")
public class RoleResourceRelation extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "资源ID")
    private Long resourceId;
}

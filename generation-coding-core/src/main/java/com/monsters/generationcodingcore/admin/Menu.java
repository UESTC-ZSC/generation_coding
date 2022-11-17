package com.monsters.generationcodingcore.admin;

import com.monsters.common.entity.HasTimeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 后台菜单表
 *
 * @author Monsters
 * @date 2022/9/10 4:35 PM
 */
@Data
@Entity
@ApiModel(value = "Menu对象", description = "后台菜单表")
public class Menu extends HasTimeEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父级ID")
    private Long parentId;

    @ApiModelProperty(value = "菜单名称")
    private String title;

    @ApiModelProperty(value = "菜单级数")
    private Integer level;

    @ApiModelProperty(value = "菜单排序")
    private Integer sort;

    @ApiModelProperty(value = "前端名称")
    private String name;

    @ApiModelProperty(value = "前端图标")
    private String icon;

    @ApiModelProperty(value = "前端隐藏")
    private Integer hidden;
}

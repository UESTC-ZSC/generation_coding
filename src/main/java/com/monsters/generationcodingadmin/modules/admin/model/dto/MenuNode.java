package com.monsters.generationcodingadmin.modules.admin.model.dto;

import com.monsters.generationcodingadmin.modules.admin.entity.Menu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/10 5:49 PM
 */
@Getter
@Setter
public class MenuNode extends Menu {

    @ApiModelProperty(value = "子级菜单")
    private List<MenuNode> children;
}

package com.monsters.admin.model.dto.menu;

import com.monsters.common.web.BasePageDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Monsters
 * @date 2022/10/12 11:40 PM
 */
@Data
@ApiModel("菜单分页查询DTO")
public class MenuPageDTO extends BasePageDTO {

    private Long parentId;
}

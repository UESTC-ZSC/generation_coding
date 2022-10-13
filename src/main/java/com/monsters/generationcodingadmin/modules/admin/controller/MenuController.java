package com.monsters.generationcodingadmin.modules.admin.controller;

import com.monsters.generationcodingadmin.common.web.PageData;
import com.monsters.generationcodingadmin.modules.admin.entity.Menu;
import com.monsters.generationcodingadmin.modules.admin.model.dto.menu.MenuPageDTO;
import com.monsters.generationcodingadmin.modules.admin.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author Monsters
 * @date 2022/10/11 10:53 AM
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation("分页查询后台菜单")
    @PostMapping("/query")
    public PageData<Page<Menu>> query(@RequestBody MenuPageDTO menuPageDTO) {
        return PageData.convertPageData(this.menuService.list(menuPageDTO));
    }
}

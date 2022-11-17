package com.monsters.admin.controller;

import com.monsters.generationcodingcore.admin.Menu;
import com.monsters.admin.model.dto.menu.MenuNode;
import com.monsters.admin.model.dto.menu.MenuPageDTO;
import com.monsters.admin.service.MenuService;
import com.monsters.common.web.PageData;
import com.monsters.common.web.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/11 10:53 AM
 */
@RestController
@Api(tags = "MenuController")
@Tag(name = "MenuController",description = "后台菜单管理")
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation("分页查询后台菜单")
    @PostMapping("/query")
    public PageData<Page<Menu>> query(@RequestBody MenuPageDTO menuPageDTO) {
        return PageData.convertPageData(this.menuService.list(menuPageDTO));
    }

    @ApiOperation("添加后台菜单")
    @PostMapping(value = "/create")
    public ResultData<Menu> create(@RequestBody Menu menu) {
        Menu result = menuService.create(menu);
        return ResultData.getSuccessData(result);
    }

    @ApiOperation("修改后台菜单")
    @PostMapping(value = "/update")
    public ResultData<Menu> update(@RequestBody Menu menu) {
        Menu result = menuService.update(menu);
        return ResultData.getSuccessData(result);
    }

    @ApiOperation("根据ID获取菜单详情")
    @GetMapping(value = "/{id}")
    public ResultData<Menu> getItem(@PathVariable Long id) {
        Menu menu = menuService.getById(id);
        return ResultData.getSuccessData(menu);
    }

    @ApiOperation("根据ID删除后台菜单")
    @GetMapping(value = "/delete/{id}")
    public ResultData delete(@PathVariable Long id) {
        menuService.deleteById(id);
        return ResultData.getSuccessResult();
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @GetMapping(value = "/treeList")
    public ResultData<List<MenuNode>> treeList() {
        List<MenuNode> list = menuService.treeList();
        return ResultData.getSuccessData(list);
    }

    @ApiOperation("修改菜单显示状态")
    @PostMapping(value = "/updateHidden/{id}")
    public ResultData updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
        Long result = menuService.updateHidden(id, hidden);
        return ResultData.getSuccessData(result);
    }

}

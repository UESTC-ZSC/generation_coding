package com.monsters.generationcodingadmin.modules.admin.controller;

import com.monsters.generationcodingadmin.modules.admin.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/query")
    public void query(){
         System.out.print(menuService.findAll());
    }
}

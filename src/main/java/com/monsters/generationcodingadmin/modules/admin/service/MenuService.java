package com.monsters.generationcodingadmin.modules.admin.service;

import com.monsters.generationcodingadmin.common.service.BaseService;
import com.monsters.generationcodingadmin.modules.admin.entity.Menu;
import com.monsters.generationcodingadmin.modules.admin.model.dto.menu.MenuNode;
import com.monsters.generationcodingadmin.modules.admin.model.dto.menu.MenuPageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 后台菜单管理Service
 * @author Monsters
 * @date 2022/10/10 5:47 PM
 */
public interface MenuService extends BaseService<Menu> {

    /**
     * 创建后台菜单
     */
    Menu create(Menu menu);

    /**
     * 修改后台菜单
     */
    Menu update(Menu menu);

    /**
     * 分页查询后台菜单
     */
    Page<Menu> list(MenuPageDTO menuPageDTO);

    /**
     * 树形结构返回所有菜单列表
     */
    List<MenuNode> treeList();

    /**
     * 修改菜单显示状态
     */
    long updateHidden(Long id, Integer hidden);
}

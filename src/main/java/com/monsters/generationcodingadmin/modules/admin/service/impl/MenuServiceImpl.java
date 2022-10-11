package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingadmin.modules.admin.entity.Menu;
import com.monsters.generationcodingadmin.modules.admin.model.dto.MenuNode;
import com.monsters.generationcodingadmin.modules.admin.repository.MenuInfoRepository;
import com.monsters.generationcodingadmin.modules.admin.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/10 5:47 PM
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, MenuInfoRepository> implements MenuService {

    @Override
    public Menu create(Menu menu) {
        updateLevel(menu);
        return this.insert(menu);
    }


    @Override
    public Menu update(Menu entity) {
        updateLevel(entity);
        return super.update(entity);
    }

    @Override
    public Page<Menu> list(Long parentId, Integer pageSize, Integer pageNum) {
        //TODO
        return null;
    }

    @Override
    public List<MenuNode> treeList() {
        //TODO
        return null;
    }

    @Override
    public boolean updateHidden(Long id, Integer hidden) {
        //TODO
        return false;
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(Menu menu) {
        if (menu.getParentId() == 0) {
            // 一级菜单
            menu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            Menu parentMenu = getById(menu.getParentId());
            if (parentMenu != null) {
                menu.setLevel(parentMenu.getLevel() + 1);
            } else {
                menu.setLevel(0);
            }
        }
    }
}

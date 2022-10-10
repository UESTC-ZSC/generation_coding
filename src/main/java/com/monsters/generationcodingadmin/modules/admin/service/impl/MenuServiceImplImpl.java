package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingadmin.modules.admin.entity.Menu;
import com.monsters.generationcodingadmin.modules.admin.model.dto.MenuNode;
import com.monsters.generationcodingadmin.modules.admin.repository.MenuInfoRepository;
import com.monsters.generationcodingadmin.modules.admin.service.MenuService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/10 5:47 PM
 */
@Service
public class MenuServiceImplImpl extends BaseServiceImpl<Menu, MenuInfoRepository> implements MenuService{


    @Override
    public boolean create(Menu menu) {
        //TODO
        return false;
    }

    @Override
    public boolean update(Long id, Menu menu) {
        //TODO
        return false;
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
}

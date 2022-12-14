package com.monsters.admin.service.impl;

import com.monsters.common.service.impl.BaseServiceImpl;
import com.monsters.generationcodingcore.admin.Menu;
import com.monsters.admin.model.dto.menu.MenuPageDTO;
import com.monsters.admin.repository.MenuInfoRepository;
import com.monsters.admin.service.MenuService;
import com.monsters.admin.model.dto.menu.MenuNode;
import com.monsters.generationcodingcore.admin.QMenu;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Monsters
 * @date 2022/10/10 5:47 PM
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, MenuInfoRepository> implements MenuService {


    private QMenu qMenu = QMenu.menu;


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
    public Page<Menu> list(MenuPageDTO pageDTO) {
        PageRequest request = PageRequest.of(pageDTO.getPageNum() - 1, pageDTO.getPageSize());
        BooleanBuilder builder = new BooleanBuilder();
        builder.equals(qMenu.parentId.eq(pageDTO.getParentId()));
        JPAQuery<Menu> jpaQuery = queryFactory.select(qMenu).from(qMenu);
        QueryResults<Menu> queryResults = jpaQuery.where(builder)
                .orderBy(qMenu.sort.desc())
                .offset(request.getOffset())
                .limit(request.getPageSize())
                .fetchResults();
        return new PageImpl<>(queryResults.getResults(), request, queryResults.getTotal());
    }

    @Override
    public List<MenuNode> treeList() {
        List<Menu> menuList = this.findAll();
        List<MenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public long updateHidden(Long id, Integer hidden) {
        return this.queryFactory.update(qMenu)
                .where(qMenu.id.eq(id))
                .set(qMenu.hidden, hidden)
                .execute();
    }

    /**
     * ??????????????????
     */
    private void updateLevel(Menu menu) {
        if (menu.getParentId() == 0) {
            // ????????????
            menu.setLevel(0);
        } else {
            //????????????????????????????????????level??????
            Menu parentMenu = getById(menu.getParentId());
            if (parentMenu != null) {
                menu.setLevel(parentMenu.getLevel() + 1);
            } else {
                menu.setLevel(0);
            }
        }
    }

    /**
     * ???Menu?????????MenuNode?????????children??????
     */
    private MenuNode covertMenuNode(Menu menu, List<Menu> menuList) {
        MenuNode node = new MenuNode();
        BeanUtils.copyProperties(menu, node);
        List<MenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

}

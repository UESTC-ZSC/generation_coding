package com.monsters.generationcodingadmin.modules.admin.repository;

import com.monsters.generationcodingadmin.modules.admin.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/10/10 11:04 PM
 */

public interface MenuInfoRepository extends JpaRepository<Menu, Long>, QuerydslPredicateExecutor<Menu> {
}

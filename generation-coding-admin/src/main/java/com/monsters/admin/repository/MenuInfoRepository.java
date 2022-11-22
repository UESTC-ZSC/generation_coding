package com.monsters.admin.repository;

import com.monsters.generationcodingcore.admin.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/10/10 11:04 PM
 */
@Repository
public interface MenuInfoRepository extends JpaRepository<Menu, Long>, QuerydslPredicateExecutor<Menu> {
}

package com.monsters.admin.repository;

import com.monsters.generationcodingcore.admin.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/11/6 9:11 PM
 */
@Repository
public interface RoleInfoRepository extends JpaRepository<Role, Long>, QuerydslPredicateExecutor<Role> {
}

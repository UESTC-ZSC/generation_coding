package com.monsters.admin.repository;

import com.monsters.generationcodingcore.admin.RoleMenuRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/11/6 9:05 PM
 */
@Repository
public interface RoleMenuRelationInfoRepository extends JpaRepository<RoleMenuRelation, Long> , QuerydslPredicateExecutor<RoleMenuRelation> {
}

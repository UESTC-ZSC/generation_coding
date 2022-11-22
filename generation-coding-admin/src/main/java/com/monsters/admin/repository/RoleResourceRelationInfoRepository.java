package com.monsters.admin.repository;

import com.monsters.generationcodingcore.admin.RoleResourceRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/11/6 9:08 PM
 */
@Repository
public interface RoleResourceRelationInfoRepository extends JpaRepository<RoleResourceRelation, Long>, QuerydslPredicateExecutor<RoleResourceRelation> {
}

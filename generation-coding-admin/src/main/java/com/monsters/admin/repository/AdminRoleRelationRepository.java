package com.monsters.admin.repository;

import com.monsters.generationcodingcore.admin.AdminRoleRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/10/17 11:25 AM
 */
@Repository
public interface AdminRoleRelationRepository extends JpaRepository<AdminRoleRelation, Long>, QuerydslPredicateExecutor<AdminRoleRelation> {
}

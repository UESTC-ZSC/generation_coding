package com.monsters.admin.repository;

import com.monsters.generationcodingcore.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/10/9 10:36 PM
 */
@Repository
public interface AdminInfoRepository extends JpaRepository<Admin, Long>, QuerydslPredicateExecutor<Admin> {
}

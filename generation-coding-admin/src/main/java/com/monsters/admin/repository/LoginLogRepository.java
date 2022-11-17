package com.monsters.admin.repository;


import com.monsters.generationcodingcore.admin.AdminLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/10/17 3:45 PM
 */
@Repository
public interface LoginLogRepository extends JpaRepository<AdminLoginLog, Long>, QuerydslPredicateExecutor<AdminLoginLog> {
}

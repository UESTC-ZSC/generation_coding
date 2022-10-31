package com.monsters.generationcodingadmin.modules.admin.repository;

import com.monsters.generationcodingadmin.modules.admin.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/10/18 12:46 PM
 */
@Repository
public interface ResourceInfoRepository extends JpaRepository<Resource,Long>, QuerydslPredicateExecutor<Resource> {
}

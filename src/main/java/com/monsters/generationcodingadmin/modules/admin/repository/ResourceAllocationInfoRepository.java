package com.monsters.generationcodingadmin.modules.admin.repository;

import com.monsters.generationcodingadmin.modules.admin.entity.ResourceAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Monsters
 * @date 2022/11/3 8:27 PM
 */
@Repository
public interface ResourceAllocationInfoRepository extends JpaRepository<ResourceAllocation,Long>, QuerydslPredicateExecutor<ResourceAllocation> {
}

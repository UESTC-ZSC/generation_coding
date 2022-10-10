package com.monsters.generationcodingadmin.common.service.impl;

import com.monsters.generationcodingadmin.common.service.BaseService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 基础 Service 实现类
 *
 * @author Monsters
 * @date 2022/10/10 11:11 PM
 */
public class BaseServiceImpl<K, T extends JpaRepository<K, Long>> implements BaseService {

    @Resource
    protected T repository;

    @Autowired
    protected JPAQueryFactory queryFactory;


}

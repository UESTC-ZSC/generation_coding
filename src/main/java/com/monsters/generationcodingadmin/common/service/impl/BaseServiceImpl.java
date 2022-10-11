package com.monsters.generationcodingadmin.common.service.impl;

import com.monsters.generationcodingadmin.common.service.BaseService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * 基础 Service 实现类
 *
 * @author Monsters
 * @date 2022/10/10 11:11 PM
 */
public class BaseServiceImpl<T, K extends JpaRepository<T, Long>> implements BaseService<T> {

    @Resource
    protected K repository;

    @Autowired
    protected JPAQueryFactory queryFactory;

    @Autowired
    protected EntityManager em;


    @Autowired
    private JpaEntityInformation<T, ?> entityInformation;


    @Override
    public List findAll() {
        return this.repository.findAll();
    }

    @Override
    public T getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public T insert(Object entity) {

        Assert.notNull(entity, "Entity must not be null.");

        if (entityInformation.isNew((T) entity)) {
            em.persist(entity);
            return (T) entity;
        } else {
            return em.merge((T) entity);
        }
    }


}

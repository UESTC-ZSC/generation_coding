package com.monsters.generationcodingadmin.common.service.impl;

import com.monsters.generationcodingadmin.common.service.BaseService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * 基础 Service 实现类
 *
 * @author Monsters
 * @date 2022/10/10 11:11 PM
 */
public class BaseServiceImpl<T, K extends JpaRepository<T, Long>> implements BaseService<T> {

    @Autowired(required = false)
    @Getter
    protected K repository;

    @Autowired
    protected JPAQueryFactory queryFactory;

    @Autowired
    protected EntityManager em;

    @Override
    public List<T> findAll() {
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
    public void delete(List<Long> ids) {
        this.repository.deleteAllByIdInBatch(ids);
    }

    @Override
    public T update(T entity) {
        return this.repository.save(entity);
    }

    @Override
    public T insert(T entity) {
        return this.repository.save(entity);
    }

    @Override
    public void saveBatch(Iterable<T> entities) {
        this.repository.saveAll(entities);
    }


}

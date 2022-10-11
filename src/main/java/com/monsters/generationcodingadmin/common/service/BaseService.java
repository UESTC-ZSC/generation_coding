package com.monsters.generationcodingadmin.common.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 基础 Service 实现类
 * 封装基础查询
 *
 * @author Monsters
 * @date 2022/10/10 11:20 PM
 */
public interface BaseService<T> {

    /**
     * 查询所有
     */
    List<T> findAll();

    /**
     * 根据 id 查询
     */
    T getById(Long id);

    /**
     * 根据 id 删除
     */
    void deleteById(Long id);

    /**
     * 插入实体
     */
    T insert(T entity);
}

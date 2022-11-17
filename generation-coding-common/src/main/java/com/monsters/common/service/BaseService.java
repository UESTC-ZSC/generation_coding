package com.monsters.common.service;

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
     * 批量删除
     */
    void delete(List<Long> ids);

    /**
     * 插入实体
     */
    T insert(T entity);

    /**
     * 批量插入
     */
    void saveBatch(Iterable<T> entities);

    /**
     * 更新实体
     */
    T update(T entity);
}

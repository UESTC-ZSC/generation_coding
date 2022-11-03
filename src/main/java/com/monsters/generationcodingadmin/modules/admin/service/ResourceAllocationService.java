package com.monsters.generationcodingadmin.modules.admin.service;

import com.monsters.generationcodingadmin.common.service.BaseService;
import com.monsters.generationcodingadmin.modules.admin.entity.ResourceAllocation;

import java.util.List;

/**
 * 后台资源分类管理Service
 * @author Monsters
 * @date 2022/10/10 5:53 PM
 */
public interface ResourceAllocationService extends BaseService<ResourceAllocation> {

    /**
     * 获取所有资源分类
     */
    List<ResourceAllocation> findAll();

    /**
     * 创建资源分类
     */
    ResourceAllocation insert(ResourceAllocation resourceAllocation);
}

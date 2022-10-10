package com.monsters.generationcodingadmin.modules.admin.service;

import com.monsters.generationcodingadmin.modules.admin.entity.Resource;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 后台资源管理Service
 * @author Monsters
 * @date 2022/10/9 11:32 PM
 */
public interface ResourceService {
    /**
     * 添加资源
     */
    boolean create(Resource umsResource);

    /**
     * 修改资源
     */
    boolean update(Long id, Resource umsResource);

    /**
     * 删除资源
     */
    boolean delete(Long id);

    /**
     * 分页查询资源
     */
    Page<Resource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    List<Resource> list();
}

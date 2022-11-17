package com.monsters.admin.service;

import com.monsters.generationcodingcore.admin.Resource;
import com.monsters.common.service.BaseService;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 后台资源管理Service
 *
 * @author Monsters
 * @date 2022/10/9 11:32 PM
 */
public interface ResourceService extends BaseService<Resource> {
    /**
     * 添加资源
     */
    Resource insert(Resource resource);

    /**
     * 修改资源
     */
    Resource update(Resource umsResource);


    /**
     * 分页查询资源
     */
    Page<Resource> list(Long id, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);


    /**
     * 获取用户所有可访问资源
     */
    List<Resource> getResourceList(Long adminId);
}

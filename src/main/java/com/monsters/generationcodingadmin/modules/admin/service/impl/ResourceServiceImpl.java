package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.modules.admin.entity.Resource;
import com.monsters.generationcodingadmin.modules.admin.service.ResourceService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/9 11:32 PM
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Override
    public boolean create(Resource umsResource) {
        //TODO
        return false;
    }

    @Override
    public boolean update(Long id, Resource umsResource) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(Long id) {
        //TODO
        return false;
    }

    @Override
    public Page<Resource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        //TODO
        return null;
    }

    @Override
    public List<Resource> list() {
        //TODO
        return null;
    }
}

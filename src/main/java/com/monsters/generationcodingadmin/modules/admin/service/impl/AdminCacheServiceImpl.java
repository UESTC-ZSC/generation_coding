package com.monsters.generationcodingadmin.modules.admin.service.impl;

import com.monsters.generationcodingadmin.common.service.RedisService;
import com.monsters.generationcodingadmin.modules.admin.entity.Admin;
import com.monsters.generationcodingadmin.modules.admin.entity.Resource;
import com.monsters.generationcodingadmin.modules.admin.service.AdminCacheService;
import com.monsters.generationcodingadmin.modules.admin.service.AdminRoleRelationService;
import com.monsters.generationcodingadmin.modules.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/10/10 5:05 PM
 */
@Service
public class AdminCacheServiceImpl implements AdminCacheService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private AdminRoleRelationService adminRoleRelationService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;

    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;

    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Override
    public void delAdmin(Long adminId) {
        Admin admin = adminService.getById(adminId);
        if (admin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public void delResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.del(key);
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        //TODO
    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {
        //TODO
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        //TODO
    }

    @Override
    public Admin getAdmin(String username) {
        //TODO
        return null;
    }

    @Override
    public void setAdmin(Admin admin) {
        //TODO
    }

    @Override
    public List<Resource> getResourceList(Long adminId) {
        //TODO
        return null;
    }

    @Override
    public void setResourceList(Long adminId, List<Resource> resourceList) {
        //TODO
    }
}

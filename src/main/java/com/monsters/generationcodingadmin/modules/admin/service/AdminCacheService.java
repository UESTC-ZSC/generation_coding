package com.monsters.generationcodingadmin.modules.admin.service;

import com.monsters.generationcodingadmin.modules.admin.entity.Admin;
import com.monsters.generationcodingadmin.modules.admin.entity.Resource;

import java.util.List;

/**
 * 后台用户缓存管理Service
 * @author Monsters
 * @date 2022/10/10 5:05 PM
 */
public interface AdminCacheService {

    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);

    /**
     * 删除后台用户资源列表缓存
     */
    void delResourceList(Long adminId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRole(Long roleId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRoleIds(List<Long> roleIds);

    /**
     * 当资源信息改变时，删除资源项目后台用户缓存
     */
    void delResourceListByResource(Long resourceId);

    /**
     * 获取缓存后台用户信息
     */
    Admin getAdmin(String username);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(Admin admin);

    /**
     * 获取缓存后台用户资源列表
     */
    List<Resource> getResourceList(Long adminId);

    /**
     * 设置后台后台用户资源列表
     */
    void setResourceList(Long adminId, List<Resource> resourceList);
}
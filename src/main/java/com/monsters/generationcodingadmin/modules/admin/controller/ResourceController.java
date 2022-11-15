package com.monsters.generationcodingadmin.modules.admin.controller;

import com.monsters.generationcodingadmin.common.web.PageData;
import com.monsters.generationcodingadmin.common.web.ResultData;
import com.monsters.generationcodingadmin.modules.admin.entity.Resource;
import com.monsters.generationcodingadmin.modules.admin.service.ResourceService;
import com.monsters.generationcodingadmin.security.component.DynamicSecurityMetadataSource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源管理Controller
 *
 * @author Monsters
 * @date 2022/11/15 3:54 PM
 */
@RestController
@Api(tags = "ResourceController")
@Tag(name = "ResourceController", description = "后台资源管理")
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;


    @ApiOperation("添加后台资源")
    @PostMapping(value = "/create")
    public ResultData<Resource> create(@RequestBody Resource resource) {
        Resource data = resourceService.insert(resource);
        dynamicSecurityMetadataSource.clearDataSource();
        return ResultData.getSuccessData(data);
    }

    @ApiOperation("修改后台资源")
    @PostMapping(value = "/update")
    public ResultData<Resource> update(@RequestBody Resource resource) {
        Resource data = resourceService.update(resource);
        dynamicSecurityMetadataSource.clearDataSource();
        return ResultData.getSuccessData(data);
    }

    @ApiOperation("根据ID获取资源详情")
    @GetMapping(value = "/{id}")
    public ResultData<Resource> getItem(@PathVariable Long id) {
        Resource resource = resourceService.getById(id);
        return ResultData.getSuccessData(resource);
    }

    @ApiOperation("根据ID删除后台资源")
    @PostMapping(value = "/delete/{id}")
    public ResultData delete(@PathVariable Long id) {
        resourceService.deleteById(id);
        dynamicSecurityMetadataSource.clearDataSource();
        return ResultData.getSuccessResult();
    }

    @ApiOperation("分页模糊查询后台资源")
    @GetMapping(value = "/list")
    public PageData<Resource> list(@RequestParam(required = false) Long categoryId,
                                   @RequestParam(required = false) String nameKeyword,
                                   @RequestParam(required = false) String urlKeyword,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<Resource> resourceList = resourceService.list(categoryId, nameKeyword, urlKeyword, pageSize, pageNum);
        return PageData.convertPageData(resourceList);
    }

    @ApiOperation("查询所有后台资源")
    @PostMapping(value = "/listAll")
    public ResultData<List<Resource>> listAll() {
        List<Resource> resourceList = resourceService.findAll();
        return ResultData.getSuccessData(resourceList);
    }

}

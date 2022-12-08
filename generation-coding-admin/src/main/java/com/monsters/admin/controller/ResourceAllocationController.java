package com.monsters.admin.controller;

import com.monsters.generationcodingcore.admin.ResourceAllocation;
import com.monsters.common.web.ResultData;
import com.monsters.admin.service.ResourceAllocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源分类管理Controller
 *
 * @author Monsters
 * @date 2022/11/15 3:31 PM
 */
@RestController
@Api(tags = "资源分类管理接口")
@RequestMapping("/api/resourceAllocation")
public class ResourceAllocationController {

    @Autowired
    ResourceAllocationService resourceAllocationService;

    @ApiOperation("查询所有后台资源分类")
    @PostMapping(value = "/listAll")
    public ResultData<List<ResourceAllocation>> listAll() {
        List<ResourceAllocation> resourceList = resourceAllocationService.findAll();
        return ResultData.getSuccessData(resourceList);
    }

    @ApiOperation("添加后台资源分类")
    @PostMapping(value = "/create")
    public ResultData<ResourceAllocation> create(@RequestBody ResourceAllocation resourceAllocation) {
        ResourceAllocation data = resourceAllocationService.insert(resourceAllocation);
        return ResultData.getSuccessData(data);
    }

    @ApiOperation("修改后台资源分类")
    @PostMapping(value = "/update/{id}")
    public ResultData<ResourceAllocation> update(@RequestBody ResourceAllocation resourceAllocation) {
        ResourceAllocation data = resourceAllocationService.update(resourceAllocation);
        return ResultData.getSuccessData(data);
    }

    @ApiOperation("根据ID删除后台资源")
    @PostMapping(value = "/delete/{id}")
    public ResultData delete(@PathVariable Long id) {
        resourceAllocationService.deleteById(id);
        return ResultData.getSuccessResult();
    }

}

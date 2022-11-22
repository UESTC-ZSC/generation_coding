package com.monsters.admin.controller;

import com.monsters.common.web.PageData;
import com.monsters.common.web.ResultData;
import com.monsters.generationcodingcore.admin.Menu;
import com.monsters.generationcodingcore.admin.Resource;
import com.monsters.generationcodingcore.admin.Role;
import com.monsters.admin.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Monsters
 * @date 2022/11/15 4:07 PM
 */
@RestController
@Api(tags = "用户角色管理接口")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("添加角色")
    @PostMapping(value = "/create")
    public ResultData<Role> create(@RequestBody Role role) {
        Role data = roleService.insert(role);
        return ResultData.getSuccessData(data);
    }

    @ApiOperation("修改角色")
    @PostMapping(value = "/update")
    public ResultData<Role> update(@RequestBody Role role) {
        Role data = roleService.update(role);
        return ResultData.getSuccessData(data);
    }

    @ApiOperation("批量删除角色")
    @PostMapping(value = "/delete")
    public ResultData delete(@RequestParam("ids") List<Long> ids) {
        roleService.delete(ids);
        return ResultData.getSuccessResult();
    }


    @ApiOperation("获取所有角色")
    @GetMapping(value = "/listAll")
    public ResultData<List<Role>> listAll() {
        List<Role> roleList = roleService.findAll();
        return ResultData.getSuccessData(roleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @GetMapping(value = "/list")
    public PageData<Role> list(@RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<Role> roleList = roleService.list(keyword, pageSize, pageNum);
        return PageData.convertPageData(roleList);
    }

    @ApiOperation("修改角色状态")
    @PostMapping(value = "/updateStatus/{id}")
    public ResultData updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        Role umsRole = new Role();
        umsRole.setId(id);
        umsRole.setStatus(status);
        // TODO 需要修改接口
        Role success = roleService.update(umsRole);
        return ResultData.getSuccessData(success);
    }

    @ApiOperation("获取角色相关菜单")
    @GetMapping(value = "/listMenu/{roleId}")
    public ResultData<List<Menu>> listMenu(@PathVariable Long roleId) {
        List<Menu> roleList = roleService.listMenu(roleId);
        return ResultData.getSuccessData(roleList);
    }

    @ApiOperation("获取角色相关资源")
    @GetMapping(value = "/listResource/{roleId}")
    public ResultData<List<Resource>> listResource(@PathVariable Long roleId) {
        List<Resource> roleList = roleService.listResource(roleId);
        return ResultData.getSuccessData(roleList);
    }

    @ApiOperation("给角色分配菜单")
    @PostMapping(value = "/allocMenu")
    public ResultData allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return ResultData.getSuccessData(count);
    }

    @ApiOperation("给角色分配资源")
    @PostMapping(value = "/allocResource")
    public ResultData allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int count = roleService.allocResource(roleId, resourceIds);
        return ResultData.getSuccessData(count);
    }
}

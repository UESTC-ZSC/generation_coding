package com.monsters.generationcodingadmin.modules.admin.controller;

import cn.hutool.core.collection.CollUtil;
import com.monsters.generationcodingadmin.common.web.PageData;
import com.monsters.generationcodingadmin.common.web.ResultData;
import com.monsters.generationcodingadmin.modules.admin.entity.Admin;
import com.monsters.generationcodingadmin.modules.admin.entity.Role;
import com.monsters.generationcodingadmin.modules.admin.model.dto.AdminLoginDTO;
import com.monsters.generationcodingadmin.modules.admin.model.dto.AdminRegisterDTO;
import com.monsters.generationcodingadmin.modules.admin.model.dto.UpdateAdminPasswordDTO;
import com.monsters.generationcodingadmin.modules.admin.service.AdminService;
import com.monsters.generationcodingadmin.modules.admin.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Monsters
 * @date 2022/10/17 4:31 PM
 */
@RestController
@Api(tags = "AdminController")
@Tag(name = "AdminController", description = "后台用户管理")
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public ResultData<Admin> register(@Validated @RequestBody AdminRegisterDTO adminRegisterDTO) {
        Admin admin = adminService.register(adminRegisterDTO);
        if (admin == null) {
            return ResultData.getFailResult("用户名已存在");
        }
        return ResultData.getSuccessData(admin);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public ResultData login(@Validated @RequestBody AdminLoginDTO adminLoginDTO) {
        String token = adminService.login(adminLoginDTO.getUsername(), adminLoginDTO.getPassword());
        if (token == null) {
            return ResultData.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResultData.getSuccessData(tokenMap);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public ResultData refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return ResultData.getFailResult("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return ResultData.getSuccessData(tokenMap);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/getLoginInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResultData getAdminInfo(Principal principal) {
        if (principal == null) {
            return ResultData.unauthorized(null);
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", admin.getUsername());
        data.put("menus", roleService.getMenuList(admin.getId()));
        data.put("icon", admin.getIcon());
        List<Role> roleList = adminService.getRoleList(admin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(Role::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        return ResultData.getSuccessData(data);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResultData logout() {
        return ResultData.getSuccessResult();
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageData<Admin> list(@RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<Admin> adminList = adminService.list(keyword, pageSize, pageNum);
        return PageData.convertPageData(adminList);
    }

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<Admin> getItem(@PathVariable Long id) {
        Admin admin = adminService.getById(id);
        return ResultData.getSuccessData(admin);
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultData<Admin> update(@RequestBody Admin admin) {
        return ResultData.getSuccessData(adminService.update(admin));
    }

    @ApiOperation("修改指定用户密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public ResultData updatePassword(@Validated @RequestBody UpdateAdminPasswordDTO updatePasswordParam) {
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return ResultData.getSuccessData(status);
        } else if (status == -1) {
            return ResultData.getFailResult("提交参数不合法");
        } else if (status == -2) {
            return ResultData.getFailResult("找不到该用户");
        } else if (status == -3) {
            return ResultData.getFailResult("旧密码错误");
        } else {
            return ResultData.getFailResult();
        }
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultData delete(@PathVariable Long id) {
        boolean success = adminService.delete(id);
        if (success) {
            return ResultData.getSuccessResult();
        }
        return ResultData.getFailResult();
    }


    @ApiOperation("修改帐号状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultData updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        Admin admin = new Admin();
        admin.setStatus(status);
        admin.setId(id);
        //TODO 修改单独接口
        Admin result = adminService.update(admin);
        return ResultData.getSuccessData(result);
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultData updateRole(@RequestParam("adminId") Long adminId,
                                 @RequestParam("roleIds") List<Long> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return ResultData.getSuccessData(count);
        }
        return ResultData.getFailResult();
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/roleById/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public ResultData<List<Role>> getRoleList(@PathVariable Long adminId) {
        List<Role> roleList = adminService.getRoleList(adminId);
        return ResultData.getSuccessData(roleList);
    }


}

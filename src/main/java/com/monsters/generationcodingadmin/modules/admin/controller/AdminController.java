package com.monsters.generationcodingadmin.modules.admin.controller;

import com.monsters.generationcodingadmin.common.web.ResultData;
import com.monsters.generationcodingadmin.modules.admin.entity.Admin;
import com.monsters.generationcodingadmin.modules.admin.model.dto.AdminRegisterDTO;
import com.monsters.generationcodingadmin.modules.admin.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public ResultData<Admin> register(@Validated @RequestBody AdminRegisterDTO adminRegisterDTO) {
        Admin admin = adminService.register(adminRegisterDTO);
        if (admin == null) {
            return ResultData.getFailResult();
        }
        return ResultData.getSuccessData(admin);
    }
}

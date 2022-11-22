package com.monsters.admin.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * @author Monsters
 * @date 2022/10/18 11:39 AM
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdminLoginDTO {
    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}

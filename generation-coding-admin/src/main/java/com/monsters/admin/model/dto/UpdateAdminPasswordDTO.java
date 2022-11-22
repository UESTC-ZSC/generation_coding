package com.monsters.admin.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Monsters
 * @date 2022/9/14 5:50 PM
 */
@Data
public class UpdateAdminPasswordDTO {

    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "旧密码", required = true)
    private String oldPassword;

    @NotEmpty
    @ApiModelProperty(value = "新密码", required = true)
    private String newPassword;
}

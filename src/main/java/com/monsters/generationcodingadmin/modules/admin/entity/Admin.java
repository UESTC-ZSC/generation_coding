package com.monsters.generationcodingadmin.modules.admin.entity;

import com.monsters.generationcodingadmin.common.entity.HasCreateEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

/**
 * 后台用户表
 *
 * @author Monsters
 * @date 2022/9/10 4:34 PM
 */
@Data
@Entity
@ApiModel(value = "Admin对象", description = "后台用户表")
public class Admin extends HasCreateEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "备注信息")
    private String note;

    @ApiModelProperty(value = "最后登录时间")
    private Date loginTime;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;
}

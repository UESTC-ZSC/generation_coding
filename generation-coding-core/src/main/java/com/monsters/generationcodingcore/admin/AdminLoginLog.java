package com.monsters.generationcodingcore.admin;

import com.monsters.common.entity.HasTimeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 后台用户登录日志表
 *
 * @author Monsters
 * @date 2022/9/10 4:55 PM
 */
@Data
@Entity
@ApiModel(value = "AdminLoginLog对象", description = "后台用户登录日志表")
public class AdminLoginLog extends HasTimeEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "登陆用户id")
    private Long adminId;

    @ApiModelProperty(value = "登陆用户ip")
    private String ip;

    @ApiModelProperty(value = "登陆用户地址")
    private String address;

    @ApiModelProperty(value = "浏览器登录类型")
    private String userAgent;
}

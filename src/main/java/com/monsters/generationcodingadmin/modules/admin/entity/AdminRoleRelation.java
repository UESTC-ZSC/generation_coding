package com.monsters.generationcodingadmin.modules.admin.entity;

import com.monsters.generationcodingadmin.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 后台用户和角色关系表
 *
 * @author Monsters
 * @date 2022/9/10 5:01 PM
 */
@Data
@Entity
@ApiModel(value = "AdminRoleRelation对象", description = "后台用户和角色关系表")
public class AdminRoleRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long adminId;

    private Long roleId;
}

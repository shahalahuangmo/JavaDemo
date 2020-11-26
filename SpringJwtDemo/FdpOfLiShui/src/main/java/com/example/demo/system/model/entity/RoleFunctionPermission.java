package com.example.demo.system.model.entity;

import com.example.demo.system.common.BaseEntity;
import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 角色功能权限
 */
@Data
@Table(name = "roleFunctionPermission")
public class RoleFunctionPermission extends BaseOrderEntity {

    /**
     * 角色Id
     */
    @Column(name = "roleId",type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long roleId;

    /**
     * 功能编码
     */
    @Column(name = "roleId",type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private String functionCode;
}

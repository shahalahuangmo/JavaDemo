package com.example.demo.system.model.entity;

import com.example.demo.system.common.BaseEntity;
import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 用户角色
 */
@Data
@Table(name = "userRole")
public class UserRole extends BaseOrderEntity {
    /**
     * 用户Id
     */
    @Column(name = "roleId",type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long userId;

    /**
     * 角色Id
     */
    @Column(name = "roleId",type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long roleId;
}

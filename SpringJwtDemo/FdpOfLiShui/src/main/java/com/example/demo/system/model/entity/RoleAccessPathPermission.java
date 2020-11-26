package com.example.demo.system.model.entity;

import com.example.demo.system.common.BaseEntity;
import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 角色访问路径权限
 */
@Data
@Table(name = "roleAccessPathPermission")
public class RoleAccessPathPermission extends BaseOrderEntity {
    /**
     * 角色Id
     */
    @Column(name = "roleId",type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long roleId;

    /**
     * 访问路径Id
     */
    @Column(name = "accessPathId",type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long accessPathId;

}

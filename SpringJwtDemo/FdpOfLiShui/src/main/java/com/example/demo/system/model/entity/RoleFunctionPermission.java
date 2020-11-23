package com.example.demo.system.model.entity;

import com.example.demo.system.common.BaseEntity;
import lombok.Data;

/**
 * 角色功能权限
 */
@Data
public class RoleFunctionPermission extends BaseEntity {

    /**
     * 角色Id
     */
    private long roleId;

    /**
     * 功能编码
     */
    private String functionCode;

    /**
     * 序号
     */
    private Integer orderId;
}

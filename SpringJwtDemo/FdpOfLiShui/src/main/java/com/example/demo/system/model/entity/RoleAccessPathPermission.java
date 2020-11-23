package com.example.demo.system.model.entity;

import com.example.demo.system.common.BaseEntity;
import lombok.Data;

/**
 * 角色访问路径权限
 */
@Data
public class RoleAccessPathPermission extends BaseEntity {
    /**
     * 角色Id
     */
    private long roleId;

    /**
     * 访问路径Id
     */
    private long accessPathId;

    /**
     * 序号
     */
    private Integer orderId;
}

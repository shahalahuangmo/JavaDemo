package com.example.demo.system.model.entity;

import com.example.demo.system.common.BaseEntity;
import lombok.Data;

/**
 * 用户角色
 */
@Data
public class UserRole extends BaseEntity {
    /**
     * 用户Id
     */
    private long userId;

    /**
     * 角色Id
     */
    private long roleId;

    /**
     * 序号
     */
    private Integer orderId;
}

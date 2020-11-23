package com.example.demo.system.model.domain;

import com.example.demo.system.common.BaseEntity;
import lombok.Data;

/**
 * 系统角色表
 */
@Data
public class Role  extends BaseEntity
{
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色名称
     */
    private String roleCode;
    /**
     * 描述
     */
    private String displayName;
    /**
     * 序号
     */
    private Integer orderId;
}

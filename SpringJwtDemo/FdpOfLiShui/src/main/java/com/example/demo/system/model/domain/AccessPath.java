package com.example.demo.system.model.domain;

import com.example.demo.system.common.BaseEntity;
import lombok.Data;

/**
 * 访问路径
 */
@Data
public class AccessPath  extends BaseEntity {
    /**
     * 访问名称
     */
    private String accessName;

    /**
     * 访问路径
     */
    private String accessPath;

    /**
     * 描述
     */
    private String displayName;

    /**
     * 序号
     */
    private Integer orderId;
}

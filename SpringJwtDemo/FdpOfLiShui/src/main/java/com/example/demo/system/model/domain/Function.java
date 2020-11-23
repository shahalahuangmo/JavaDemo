package com.example.demo.system.model.domain;

import lombok.Data;

@Data
public class Function {
    /**
     * 功能编码
     */
    private String functionCode;
    /**
     * 功能父编码
     */
    private String functionParentCode;
    /**
     * 功能名称
     */
    private String name;
    /**
     * 功能层级
     */
    private Integer functionLevel;
    /**
     * 描述
     */
    private String displayName;
    /**
     * url 地址
     */
    private String urlAddress;
    /**
     * 序号
     */
    private Integer orderId;
}

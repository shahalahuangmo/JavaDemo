package com.example.demo.dto.output.houseinfo;


import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;

/**
 * 楼层信息
 */
public class FloorOutput  extends BaseOrderEntity {

    /**
     * 楼层名称
     */
    @IsNotNull
    private String floorName;

    /**
     * 楼层说明
     */
    private String floorContent;
}

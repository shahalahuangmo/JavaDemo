package com.example.demo.dto.output.houseinfo;

import com.example.demo.system.common.BaseOrderEntity;
import lombok.Data;

import java.util.List;

/**
 * 楼栋信息
 */
@Data
public class BuildingOutput extends BaseOrderEntity {
    /**
     * 楼栋名称
     */
    private String buildingName;

    /**
     * 楼栋说明
     */
    public String buildingContent;

    /**
     * 该楼栋下楼层信息
     */
    public List<FloorOutput> floorList;

    /**
     * 楼栋床位总数
     */
    public int buildingBedNumber;

    /**
     * 楼栋占用床位数
     */
    public int buildingOccupyBedNumber;

    /**
     * 楼栋空闲床位数
     */
    public int buildingVacantBedNumber;

    /**
     * 楼层数量
     */
    public int floorNumber;
}

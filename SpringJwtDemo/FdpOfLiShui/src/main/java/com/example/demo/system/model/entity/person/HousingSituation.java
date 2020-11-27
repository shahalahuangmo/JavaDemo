package com.example.demo.system.model.entity.person;

import com.example.demo.system.common.BaseOrderEntity;
import com.example.demo.system.model.value.*;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 住房情况
 */
@Data
@Table(name = "housingSituation")
public class HousingSituation extends BaseOrderEntity {
    /**
     * 个人信息Id
     */
    @Column(name = "personId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long personId;

    /**
     * 建筑面积
     */
    @Column(name = "houseArea", type = MySqlTypeConstant.VARCHAR, length = 50)
    @IsNotNull
    private String houseArea;

    /**
     * 房屋质量
     */
    @Column(name = "houseQuality", type = MySqlTypeConstant.INT)
    @IsNotNull
    private HouseQuality houseQuality;

    /**
     * 建筑日期（年月）
     */
    @Column(name = "houseConstructionDate", type = MySqlTypeConstant.VARCHAR, length = 50)
    @IsNotNull
    private String houseConstructionDate;

    /**
     * 建筑结构
     */
    @Column(name = "buildingStructure", type = MySqlTypeConstant.INT)
    @IsNotNull
    private BuildingStructure buildingStructure;

    /**
     * 其他建筑结构说明
     */
    @Column(name = "otherBuildingStructure", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String otherBuildingStructure;

    /**
     * 住房结构
     */
    @Column(name = "housingStructure", type = MySqlTypeConstant.INT)
    @IsNotNull
    private HousingStructure housingStructure;

    /**
     * 产权及其来源
     */
    @Column(name = "houseRightAndSource", type = MySqlTypeConstant.INT)
    @IsNotNull
    private HouseRightSource houseRightAndSource;

    /**
     * 其他产权来源说明
     */
    @Column(name = "otherSourceDescription", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String otherSourceDescription;

    /**
     * 户内人均使用面积
     */
    @Column(name = "housePerUseArea", type = MySqlTypeConstant.INT)
    @IsNotNull
    private HousePerUseArea housePerUseArea;
}

package com.example.demo.system.model.domain.personinfo;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.*;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 人员信息
 */
@Data
@Table(name = "person")
public class Person extends FuLLBaseDateEntity {

    /**
     * 入托申请Id
     */
    @Column(name = "nurseryApplicationId", type = MySqlTypeConstant.BIGINT)
    private Long nurseryApplicationId;

    /**
     * 入托人Id
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.BIGINT)
    private long entrepreneurId;

    /**
     * 残疾人证号
     */
    @Column(name = "disabledCardNumber", type = MySqlTypeConstant.VARCHAR, length = 30)
    @IsNotNull
    private String disabledCardNumber;

    /**
     * 残疾人姓名
     */
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 50)
    @IsNotNull
    private String name;

    /**
     * 性别
     */
    @Column(name = "gender", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Gender gender;

    /**
     * 婚姻状况
     */
    @Column(name = "marriageStatus", type = MySqlTypeConstant.INT)
    @IsNotNull
    private MarriageStatus marriageStatus;

    /**
     * 出生年月
     */
    @Column(name = "birthDate", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String birthDate;

    /**
     * 民族
     */
    @Column(name = "nationType", type = MySqlTypeConstant.INT)
    private NationType nationType;

    /**
     * 文化程度
     */
    @Column(name = "educationalLevel", type = MySqlTypeConstant.INT)
    private EducationalLevel educationalLevel;

    /**
     * 联系方式
     */
    @Column(name = "contactNumber", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String contactNumber;

    /**
     * 是否有生活补贴
     */
    @Column(name = "lifeSubsidy", type = MySqlTypeConstant.BIT)
    private boolean lifeSubsidy;

    /**
     * 是否有护理补贴
     */
    @Column(name = "nursingSubsidy", type = MySqlTypeConstant.BIT)
    private boolean nursingSubsidy;

    /**
     * 可享受护理等级
     */
    @Column(name = "nursingLevel", type = MySqlTypeConstant.INT)
    private NursingLevel nursingLevel;

    /**
     * 省编码
     */
    @Column(name = "provinceCode", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String provinceCode;

    /**
     * 市编码
     */
    @Column(name = "cityCode", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String cityCode;

    /**
     * 县/区编码
     */
    @Column(name = "countyCode", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String countyCode;

    /**
     * 家庭住址
     */
    @Column(name = "homeAddress", type = MySqlTypeConstant.VARCHAR, length = 1000)
    private String homeAddress;

  /*  *//**
     * 收入来源
     *//*
    @Column(name = "sourceIncome", type = MySqlTypeConstant.INT)
    private SourceIncome sourceIncome;

    *//**
     * 个人平均收入
     *//*
    @Column(name = "averagePersonalIncome", type = MySqlTypeConstant.INT)
    private AveragePersonalIncome averagePersonalIncome;

    *//**
     * 其他收入来源说明
     *//*
    @Column(name = "otherInstructions", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String otherInstructions;

    *//**
     * 残疾类别
     *//*
    @Column(name = "disabilityType", type = MySqlTypeConstant.INT)
    private DisabilityType disabilityType;

    *//**
     * 残疾等级
     *//*
    @Column(name = "disabilityLevel", type = MySqlTypeConstant.INT)
    private DisabilityLevel disabilityLevel;

    *//**
     * 生活自理情况
     *//*
    @Column(name = "selfCareSituation", type = MySqlTypeConstant.INT)
    private SelfCareSituation selfCareSituation;

    *//**
     * 疾病情况
     *//*
    @Column(name = "diseaseSituation", type = MySqlTypeConstant.VARCHAR, length = 1000)
    private String diseaseSituation;

    *//**
     * 是否有攻击性
     *//*
    @Column(name = "isAggressive", type = MySqlTypeConstant.BIT)
    private boolean isAggressive;

    *//**
     * 是否有传染病
     *//*
    @Column(name = "isInfectiousDisease", type = MySqlTypeConstant.BIT)
    private boolean isInfectiousDisease;

    *//**
     * 日常服用药物
     *//*
    @Column(name = "dailyServiceDrug", type = MySqlTypeConstant.VARCHAR, length = 1000)
    private String dailyServiceDrug;

    *//**
     * 近期就医住院情况
     *//*
    @Column(name = "recentHospitalizations", type = MySqlTypeConstant.TEXT)
    private String recentHospitalizations;

    *//**
     * 其他健康情况
     *//*
    @Column(name = "otherHealthStatus", type = MySqlTypeConstant.TEXT)
    private String otherHealthStatus;

    *//**
     * 监护人姓名
     *//*
    @Column(name = "guardianName", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String guardianName;

    *//**
     * 监护人身份证号
     *//*
    @Column(name = "guardianCard", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String guardianCard;

    *//**
     * 监护人联系方式
     *//*
    @Column(name = "guardianContactNumber", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String guardianContactNumber;

    *//**
     * 监护人其他联系方式
     *//*
    @Column(name = "otherContactNumber", type = MySqlTypeConstant.VARCHAR, length = 500)
    private String otherContactNumber;

    *//**
     * 残疾人与联系人关系
     *//*
    @Column(name = "contactRelationShip", type = MySqlTypeConstant.INT)
    private ContactRelationShip contactRelationShip;

    *//**
     * 其他关系说明
     *//*
    @Column(name = "otherRelationShipDescription", type = MySqlTypeConstant.VARCHAR, length = 500)
    private String otherRelationShipDescription;

    *//**
     * 监护人地址
     *//*
    @Column(name = "guardianAddress", type = MySqlTypeConstant.VARCHAR, length = 500)
    private String guardianAddress;

    *//**
     * 其他家庭信息
     *//*
    @Column(name = "guardianOtherInformation", type = MySqlTypeConstant.TEXT)
    private String guardianOtherInformation;

    *//**
     * 建筑面积
     *//*
    @Column(name = "houseArea", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String houseArea;

    *//**
     * 房屋质量
     *//*
    @Column(name = "houseQuality", type = MySqlTypeConstant.INT)
    private HouseQuality houseQuality;

    *//**
     * 建筑日期（年月）
     *//*
    @Column(name = "houseConstructionDate", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String houseConstructionDate;

    *//**
     * 建筑结构
     *//*
    @Column(name = "buildingStructure", type = MySqlTypeConstant.INT)
    private BuildingStructure buildingStructure;

    *//**
     * 其他建筑结构说明
     *//*
    @Column(name = "otherBuildingStructure", type = MySqlTypeConstant.VARCHAR, length = 500)
    private String otherBuildingStructure;

    *//**
     * 住房结构
     *//*
    @Column(name = "housingStructure", type = MySqlTypeConstant.INT)
    private HousingStructure housingStructure;

    *//**
     * 产权及其来源
     *//*
    @Column(name = "houseRightAndSource", type = MySqlTypeConstant.INT)
    private HouseRightSource houseRightAndSource;

    *//**
     * 其他产权来源说明
     *//*
    @Column(name = "otherSourceDescription", type = MySqlTypeConstant.VARCHAR, length = 500)
    private String otherSourceDescription;

    *//**
     * 户内人均使用面积
     *//*
    @Column(name = "housePerUseArea", type = MySqlTypeConstant.INT)
    private HousePerUseArea housePerUseArea;

    *//**
     * 贫困类别
     *//*
    @Column(name = "povertyCategory", type = MySqlTypeConstant.INT)
    private PovertyCategory povertyCategory;

    *//**
     * 证号
     *//*
    @Column(name = "certificateNumber", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String certificateNumber;

    *//**
     * 年救助金额（元）
     *//*
    @Column(name = "annualRescueAmount", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String annualRescueAmount;

    *//**
     * 获得社会保障项目
     *//*
    @Column(name = "socialSecurityProject", type = MySqlTypeConstant.VARCHAR, length = 500)
    private String socialSecurityProject;

    *//**
     * 备注
     *//*
    @Column(name = "socialAssistanceSituationRemark", type = MySqlTypeConstant.TEXT)
    private String socialAssistanceSituationRemark;*/
}

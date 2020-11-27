package com.example.demo.system.model.domain.nursery;

import cn.hutool.core.date.DateTime;
import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.*;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 入托登记信息
 */
@Data
@Table(name = "nurseryRegistration")
public class NurseryRegistration extends FuLLBaseDateEntity {
    /**
     * 入托申请Id
     */
    @Column(name = "nurseryApplicationId", type = MySqlTypeConstant.BIGINT)
    private long nurseryApplicationId;

    /**
     * 残疾证号码
     */
    @Column(name = "disabledCardNumber", type = MySqlTypeConstant.VARCHAR, length = 30)
    @IsNotNull
    private String disabledCardNumber;

    /**
     * 身份证号码
     */
    @Column(name = "idCard", type = MySqlTypeConstant.VARCHAR, length = 20)
    @IsNotNull
    private String idCard;
    /**
     * 残疾人姓名
     */
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 50)
    @IsNotNull
    private String name;

    /**
     * 残疾类别
     */
    @Column(name = "disabilityType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private DisabilityType disabilityType;

    /**
     * 残疾等级
     */
    @Column(name = "disabilityLevel", type = MySqlTypeConstant.INT)
    @IsNotNull
    private DisabilityLevel disabilityLevel;

    /**
     * 有无子女
     */
    @Column(name = "hasChild", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean hasChild;

    /**
     * 低保类型
     */
    @Column(name = "subsidiaryType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private SubsidiaryType subsidiaryType;

    /**
     * 低保（元）
     */
    @Column(name = "lowSecurity", type = MySqlTypeConstant.DOUBLE)
    private Double lowSecurity;

    /**
     * 注意事项
     */
    @Column(name = "precautions", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String precautions;

    /**
     * 外科检查处理状况
     */
    @Column(name = "processingStatus", type = MySqlTypeConstant.INT)
    @IsNotNull
    private ProcessingStatus processingStatus;

    /**
     * 床位Id
     */
    @Column(name = "bedId", type = MySqlTypeConstant.BIGINT)
    private long bedId;

    /**
     * 试住意向书
     */
    @Column(name = "letterIntent", type = MySqlTypeConstant.TEXT)
    private String letterIntent;

    /**
     * 托养协议书
     */
    @Column(name = "careAgreement", type = MySqlTypeConstant.TEXT)
    private String careAgreement;

    /**
     * 服药需求[1-有|2-否]
     */
    @Column(name = "medicationRequirement", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean medicationRequirement;

    /**
     * 特殊护理需求[1-有特殊护理需求|2-无特殊护理需求]
     */
    @Column(name = "specialNursingRequirement", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean specialNursingRequirement;

    /**
     * 佩戴电子设备[1-有佩戴电子设备|2-无佩戴电子设备]
     */
    @Column(name = "wearingElectronicEquipment", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean wearingElectronicEquipment;

    /**
     * 电子设备编号
     */
    @Column(name = "electronicEquipmentNumber", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String electronicEquipmentNumber;

    /**
     * 入住状态
     */
    @Column(name = "checkInStatus", type = MySqlTypeConstant.INT)
    @IsNotNull
    private CheckInStatus checkInStatus;

    /**
     * 试入住开始时间
     */
    @Column(name = "tryCheckInStartTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private DateTime tryCheckInStartTime;

    /**
     * 正式入住开始时间
     */
    @Column(name = "formalCheckInStartTime", type = MySqlTypeConstant.DATE)
    private DateTime formalCheckInStartTime;

    /**
     * 退住时间
     */
    @Column(name = "retreatTime", type = MySqlTypeConstant.DATE)
    private DateTime retreatTime;

    /**
     * 账户金额
     */
    @Column(name = "accountAmount", type = MySqlTypeConstant.DOUBLE)
    @IsNotNull
    private Double accountAmount;
}

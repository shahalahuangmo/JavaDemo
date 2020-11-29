package com.example.demo.system.model.entity.person;

import com.example.demo.system.common.BaseOrderEntity;
import com.example.demo.system.model.value.DisabilityLevel;
import com.example.demo.system.model.value.DisabilityType;
import com.example.demo.system.model.value.SelfCareSituation;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 健康状况
 */
@Data
@Table(name = "healthStatus")
public class HealthStatus extends BaseOrderEntity {
    /**
     * 个人信息Id
     */
    @Column(name = "personId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long personId;

    /**
     * 残疾类别
     */
    @Column(name = "disabilityType", type = MySqlTypeConstant.INT)
    private DisabilityType disabilityType;

    /**
     * 残疾等级
     */
    @Column(name = "disabilityLevel", type = MySqlTypeConstant.INT)
    private DisabilityLevel disabilityLevel;

    /**
     * 生活自理情况
     */
    @Column(name = "selfCareSituation", type = MySqlTypeConstant.INT)
    @IsNotNull
    private SelfCareSituation SelfCareSituation;

    /**
     * 疾病情况
     */
    @Column(name = "diseaseSituation", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String diseaseSituation;

    /**
     * 是否有攻击性
     */
    @Column(name = "isAggressive", type = MySqlTypeConstant.BIT)
    private boolean isAggressive;

    /**
     * 是否有传染病
     */
    @Column(name = "isInfectiousDisease", type = MySqlTypeConstant.BIT)
    private boolean isInfectiousDisease;

    /**
     * 日常服用药物
     */
    @Column(name = "dailyServiceDrug", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String dailyServiceDrug;

    /**
     * 近期就医住院情况
     */
    @Column(name = "recentHospitalizations", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String recentHospitalizations;

    /**
     * 其他健康情况
     */
    @Column(name = "otherHealthStatus", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String otherHealthStatus;
}

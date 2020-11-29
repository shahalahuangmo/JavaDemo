package com.example.demo.system.model.entity.attendance;

import com.example.demo.system.common.BaseDateEntity;
import com.example.demo.system.model.value.NursingStatus;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 护理计划明细
 */
@Data
@Table(name = "nursingPlanDetail")
public class NursingPlanDetail extends BaseDateEntity {

    /**
     * 护理计划Id
     */
    @Column(name = "nursingPlanId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long nursingPlanId;

    /**
     * 护理开始时间
     */
    @Column(name = "startTime", type = MySqlTypeConstant.TIMESTAMP)
    @IsNotNull
    private Timestamp startTime;

    /**
     * 护理结束时间
     */
    @Column(name = "endTime", type = MySqlTypeConstant.TIMESTAMP)
    @IsNotNull
    private Timestamp endTime;

    /**
     * 护理项目Id
     */
    @Column(name = "nursingItemId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long nursingItemId;

    /**
     * 床位Id
     */
    @Column(name = "bedId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long bedId;

    /**
     * 入托人Id
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long entrepreneurId;

    /**
     * 护工Id
     */
    @Column(name = "nursingPersonId", type = MySqlTypeConstant.BIGINT)
    private Long nursingPersonId;

    /**
     * 护工护理操作时间
     */
    @Column(name = "nursingTime", type = MySqlTypeConstant.DATE)
    private Date nursingTime;

    /**
     * 护理状态
     */
    @Column(name = "nursingStatus", type = MySqlTypeConstant.INT)
    @IsNotNull
    private NursingStatus nursingStatus;

    /**
     * 护理说明
     */
    @Column(name = "nursingRemark", type = MySqlTypeConstant.TEXT)
    private String nursingRemark;

}

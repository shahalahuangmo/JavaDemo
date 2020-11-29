package com.example.demo.system.model.domain.medication;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 药品登记详情
 */
@Data
@Table(name = "medicamentInfo")
public class MedicamentInfo extends FuLLBaseDateEntity {

    /**
     * 入托人Id
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long entrepreneurId;

    /**
     * 药品名称
     */
    @Column(name = "medicamentName", type = MySqlTypeConstant.VARCHAR, length = 500)
    @IsNotNull
    private String medicamentName;

    /**
     * 药品总量
     */
    @Column(name = "totalMedicament", type = MySqlTypeConstant.VARCHAR, length = 500)
    @IsNotNull
    private String totalMedicament;

    /**
     * 药品用量
     */
    @Column(name = "medicamentDosage", type = MySqlTypeConstant.VARCHAR, length = 1000)
    @IsNotNull
    private String medicamentDosage;

    /**
     * 开始服用日期
     */
    @Column(name = "startTakingTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date startTakingTime;

    /**
     * 预计用完日期
     */
    @Column(name = "estimatedRunOutTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date estimatedRunOutTime;

    /**
     * 备注信息
     */
    @Column(name = "remarkInfo", type = MySqlTypeConstant.TEXT)
    private String remarkInfo;


}

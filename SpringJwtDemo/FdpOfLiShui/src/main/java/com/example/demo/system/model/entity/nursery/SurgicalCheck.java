package com.example.demo.system.model.entity.nursery;

import com.example.demo.system.common.BaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 外科检查
 */
@Data
@Table(name = "surgicalCheck")
public class SurgicalCheck extends BaseDateEntity {
    /**
     * 入托人Id
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long entrepreneurId;

    /**
     * 血糖值 默认单位（mmol/L）
     */
    @Column(name = "bloodGlucose", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    private BigDecimal bloodGlucose ;

    /**
     * 收缩压 单位（mmHg）
     */
    @Column(name = "systolicBloodPressure", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    private BigDecimal systolicBloodPressure ;

    /**
     * 舒张压 默认单位（mmHg）
     */
    @Column(name = "diastolicBloodPressure", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    private BigDecimal diastolicBloodPressure ;

    /**
     * 本人家族过敏史
     */
    @Column(name = "familyHistoryAllergies", type = MySqlTypeConstant.VARCHAR,length = 1000)
    private String familyHistoryAllergies ;

    /**
     * 体检记录
     */
    @Column(name = "medicalRecord", type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String medicalRecord ;
}

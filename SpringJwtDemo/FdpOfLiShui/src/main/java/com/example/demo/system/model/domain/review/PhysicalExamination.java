package com.example.demo.system.model.domain.review;

import com.example.demo.system.common.BaseDateEntity;
import com.example.demo.system.model.value.AuditProjectType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 入托体检
 */
@Data
@Table(name = "physicalExamination")
public class PhysicalExamination extends BaseDateEntity {
    /**
     * 审核项目类型
     */
    @Column(name = "auditProjectType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private AuditProjectType auditProjectType;

    /**
     * 入托申请Id
     */
    @Column(name = "nurseryApplicationId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long nurseryApplicationId;

    /**
     * 体检报告
     */
    @Column(name = "medicalReport", type = MySqlTypeConstant.TEXT)
    private String medicalReport;

    /**
     * 体检结论
     */
    @Column(name = "medicalConclusion", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String medicalConclusion;

    /**
     * 体检时间
     */
    @Column(name = "medicalTime", type = MySqlTypeConstant.DATE)
    private Date medicalTime;
}

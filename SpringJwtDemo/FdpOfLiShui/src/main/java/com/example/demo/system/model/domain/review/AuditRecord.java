package com.example.demo.system.model.domain.review;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.AuditProjectType;
import com.example.demo.system.model.value.AuditResult;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 审核记录
 */
@Data
@Table(name = "auditRecord")
public class AuditRecord extends FuLLBaseDateEntity {

    /**
     * 具体审核项目Id
     */
    @Column(name = "projectId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long projectId;

    /**
     * 审核项目类型
     */
    @Column(name = "auditProjectType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private AuditProjectType auditProjectType;

    /**
     * 审核人Id
     */
    @Column(name = "reviewerId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long reviewerId;

    /**
     * 审核结果状态
     */
    @Column(name = "auditResult", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private AuditResult auditResult;

    /**
     * 序号
     */
    @Column(name = "orderNumber", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer orderNumber;

    /**
     * 审核时间
     */
    @Column(name = "auditTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date auditTime;

    /**
     * 审核备注
     */
    @Column(name = "auditRemark", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String auditRemark;
}

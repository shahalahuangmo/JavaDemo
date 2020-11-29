package com.example.demo.system.model.domain.review;

import com.example.demo.system.common.BaseDateEntity;
import com.example.demo.system.model.value.AuditProjectType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 试住评估
 */
@Data
@Table(name = "resideEvaluation")
public class ResideEvaluation extends BaseDateEntity {

    /**
     * 审核项目类型
     */
    @Column(name = "auditProjectType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private AuditProjectType auditProjectType;

    /**
     * 入托人Id
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long entrepreneurId;

}

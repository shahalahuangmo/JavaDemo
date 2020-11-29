package com.example.demo.system.model.domain.review;

import com.example.demo.system.common.BaseDateEntity;
import com.example.demo.system.model.value.AuditProjectType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 审核流程
 */
@Data
@Table(name = "reviewProcess")
public class ReviewProcess extends BaseDateEntity {

    /**
     * 审核项目类型
     */
    @Column(name = "auditProjectType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private AuditProjectType auditProjectType;

    /**
     * 审核人
     */
    @Column(name = "reviewerId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long reviewerId;

    /**
     * 组织ID
     */
    @Column(name = "organizationUnitId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long organizationUnitId ;

    /**
     *  部门ID
     */
    @Column(name = "departmentId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long departmentId ;

    /**
     * 排序号
     */
    @Column(name = "orderNumber", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer orderNumber ;
}

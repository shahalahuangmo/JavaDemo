package com.example.demo.system.model.domain.Review;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.AuditProjectType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 审核项目表
 */
@Data
@Table(name = "auditProject")
public class AuditProject extends FuLLBaseDateEntity {

    /**
     * auditProjectName
     */
    @Column(name = "auditProjectName", type = MySqlTypeConstant.VARCHAR, length = 200)
    @IsNotNull
    private String auditProjectName;

    /**
     * 审核项目类型
     */
    @Column(name = "auditProjectType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private AuditProjectType auditProjectType;

    /**
     * 项目描叙
     */
    @Column(name = "auditProjectDescription", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String auditProjectDescription;

    /**
     * 是否启用（默认启用）
     */
    @Column(name = "isEnable", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean isEnable;
}

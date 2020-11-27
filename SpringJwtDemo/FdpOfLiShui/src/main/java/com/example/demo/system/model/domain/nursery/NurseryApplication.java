package com.example.demo.system.model.domain.nursery;

import com.example.demo.system.common.BaseDateEntity;
import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.AuditProjectType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name = "nurseryApplication")
public class NurseryApplication extends FuLLBaseDateEntity {
    /**
     * 残疾证号码
     */
    @Column(name = "disabledCardNumber", type = MySqlTypeConstant.VARCHAR, length = 30)
    @IsNotNull
    private String disabledCardNumber ;

    /**
     * 身份证号码
     */
    @Column(name = "idCard", type = MySqlTypeConstant.VARCHAR, length = 20)
    @IsNotNull
    private String idCard ;

    /**
     * 审核项目标识
     */
    @Column(name = "auditProjectType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private AuditProjectType auditProjectType ;

    /**
     *  其他补充说明
     */
    @Column(name = "otherSupplyInstructions", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String otherSupplyInstructions ;
}

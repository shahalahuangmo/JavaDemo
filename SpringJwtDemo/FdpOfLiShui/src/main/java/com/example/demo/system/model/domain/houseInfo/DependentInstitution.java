package com.example.demo.system.model.domain.houseInfo;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 托养机构信息
 */
@Data
@Table(name = "dependentInstitution")
public class DependentInstitution extends FuLLBaseDateEntity {
    /**
     * 托养中心机构名称
     */
    @Column(name = "dependentInstitutionName", type = MySqlTypeConstant.VARCHAR, length = 500)
    @IsNotNull
    private String dependentInstitutionName;

    /**
     * 托养中心机构行政区编码
     */
    @Column(name = "dependentInstitutionCode", type = MySqlTypeConstant.VARCHAR, length = 200)
    private String dependentInstitutionCode;

    /**
     * 托养中心机构地址
     */
    @Column(name = "dependentInstitutionAddress", type = MySqlTypeConstant.VARCHAR, length = 2000)
    @IsNotNull
    private String dependentInstitutionAddress;

    /**
     * 托养中心机构简介
     */
    @Column(name = "dependentInstitutionContent", type = MySqlTypeConstant.VARCHAR, length = 2000)
    @IsNotNull
    private String dependentInstitutionContent;
}

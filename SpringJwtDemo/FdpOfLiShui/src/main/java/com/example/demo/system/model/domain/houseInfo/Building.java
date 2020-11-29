package com.example.demo.system.model.domain.houseInfo;

import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 楼栋信息
 */
@Data
@Table(name = "building")
public class Building extends BaseOrderEntity {
    /**
     * 托养机构Id
     */
    @Column(name = "dependentInstitutionId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long dependentInstitutionId;

    /**
     * 楼栋名称
     */
    @Column(name = "buildingName", type = MySqlTypeConstant.VARCHAR, length = 200)
    @IsNotNull
    private String buildingName;

    /**
     * 楼栋说明
     */
    @Column(name = "buildingContent", type = MySqlTypeConstant.VARCHAR, length = 2000)
    private String buildingContent;

}

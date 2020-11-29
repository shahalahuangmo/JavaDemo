package com.example.demo.system.model.entity.person;

import com.example.demo.system.common.BaseOrderEntity;
import com.example.demo.system.model.value.*;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 社会救助情况
 */
@Data
@Table(name = "socialAssistanceSituation")
public class SocialAssistanceSituation extends BaseOrderEntity {
    /**
     * 个人信息Id
     */
    @Column(name = "personId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long personId;

    /**
     * 贫困类别
     */
    @Column(name = "povertyCategory", type = MySqlTypeConstant.INT)
    @IsNotNull
    private PovertyCategory povertyCategory ;

    /**
     * 证件号
     */
    @Column(name = "certificateNumber", type = MySqlTypeConstant.VARCHAR,length = 50)
    @IsNotNull
    private String certificateNumber ;

    /**
     * 年救助金额（元）
     */
    @Column(name = "annualRescueAmount", type = MySqlTypeConstant.VARCHAR,length = 50)
    @IsNotNull
    private String annualRescueAmount ;

    /**
     * 获得社会保障项目
     */
    @Column(name = "socialSecurityProject", type = MySqlTypeConstant.VARCHAR,length = 1000)
    @IsNotNull
    private String socialSecurityProject ;

    /**
     * 备注
     */
    @Column(name = "socialAssistanceSituationRemark", type = MySqlTypeConstant.VARCHAR,length = 2000)
    private String socialAssistanceSituationRemark ;
}

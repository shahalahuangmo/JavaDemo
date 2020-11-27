package com.example.demo.system.model.entity.person;

import com.example.demo.system.common.BaseOrderEntity;
import com.example.demo.system.model.value.GuardianRelationShip;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 家庭情况表
 */
@Data
@Table(name = "familySituation")
public class FamilySituation extends BaseOrderEntity {
    /**
     * 个人信息Id
     */
    @Column(name = "personId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private long personId;

    /**
     * 监护人姓名
     */
    @Column(name = "guardianName", type = MySqlTypeConstant.VARCHAR,length = 50)
    @IsNotNull
    private String guardianName ;

    /**
     * 监护人身份证号
     */
    @Column(name = "guardianCard", type = MySqlTypeConstant.VARCHAR,length = 20)
    @IsNotNull
    private String guardianCard ;

    /**
     * 监护人联系方式
     */
    @Column(name = "guardianContactNumber", type = MySqlTypeConstant.VARCHAR,length = 20)
    private String guardianContactNumber ;

    /**
     * 监护人其他联系方式
     */
    @Column(name = "otherContactNumber", type = MySqlTypeConstant.VARCHAR,length = 200)
    private String otherContactNumber ;

    /**
     * 监护人与入托人关系
     */
    @Column(name = "guardianRelationShip", type = MySqlTypeConstant.INT)
    @IsNotNull
    private GuardianRelationShip guardianRelationShip ;

    /**
     * 其他关系说明
     */
    @Column(name = "otherRelationShipDescription", type = MySqlTypeConstant.VARCHAR,length = 200)
    private String otherRelationShipDescription ;

    /**
     * 监护人地址
     */
    @Column(name = "guardianAddress", type = MySqlTypeConstant.VARCHAR,length = 500)
    private String guardianAddress ;

    /**
     * 其他家庭信息
     */
    @Column(name = "guardianOtherInformation", type = MySqlTypeConstant.VARCHAR,length = 500)
    private String guardianOtherInformation ;



}

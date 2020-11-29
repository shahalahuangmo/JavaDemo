package com.example.demo.system.model.entity.person;

import com.example.demo.system.common.BaseOrderEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 家庭成员表
 */
@Data
@Table(name = "familyMember")
public class FamilyMember extends BaseOrderEntity {
    /**
     * 个人信息Id
     */
    @Column(name = "personId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long personId;

    /**
     *  姓名
     */
    @Column(name = "familyMemberName", type = MySqlTypeConstant.VARCHAR,length = 50)
    @IsNotNull
    private String familyMemberName;

    /**
     * 年龄
     */
    @Column(name = "familyMemberAge", type = MySqlTypeConstant.VARCHAR,length = 20)
    private String familyMemberAge;

    /**
     * 监护人联系方式
     */
    @Column(name = "guardianContactNumber", type = MySqlTypeConstant.VARCHAR,length = 20)
    private String guardianContactNumber;

    /**
     * 关系
     */
    @Column(name = "familyMemberRelationShip", type = MySqlTypeConstant.VARCHAR,length = 50)
    @IsNotNull
    private String familyMemberRelationShip;

    /**
     * 经济收入
     */
    @Column(name = "familyMemberIncome", type = MySqlTypeConstant.VARCHAR,length = 500)
    private String familyMemberIncome;

    /**
     * 是否残疾
     */
    @Column(name = "familyMemberIsDisabled", type = MySqlTypeConstant.BIT)
    @IsNotNull
    private boolean familyMemberIsDisabled;

    /**
     * 家人联系方式
     */
    @Column(name = "familyMemberContactNumber", type = MySqlTypeConstant.VARCHAR,length = 50)
    private String familyMemberContactNumber;

    /**
     * 备注
     */
    @Column(name = "familyMemberRemark", type = MySqlTypeConstant.TEXT)
    private String familyMemberRemark;
}

package com.example.demo.system.model.domain.attendance;

import com.example.demo.system.common.FuLLBaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 护理员工
 */
@Data
@Table(name = "nursingPerson")
public class NursingPerson extends FuLLBaseDateEntity {

    /**
     * 护理小组ID
     */
    @Column(name = "groupId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long groupId ;

    /**
     * 系统用户ID
     */
    @Column(name = "userId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long userId ;

}

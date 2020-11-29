package com.example.demo.system.model.entity.attendance;

import com.example.demo.system.common.BaseDateEntity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 护工小组
 */
@Data
@Table(name = "nursingPersonGroup")
public class NursingPersonGroup extends BaseDateEntity {

    /**
     * 小组名称
     */
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR,length = 50)
    @IsNotNull
    private String name ;

    /**
     * 组长用户ID
     */
    @Column(name = "userId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long userId ;
}

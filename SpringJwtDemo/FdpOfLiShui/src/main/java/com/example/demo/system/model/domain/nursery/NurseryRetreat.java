package com.example.demo.system.model.domain.nursery;

import cn.hutool.core.date.DateTime;
import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.RetreatType;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 托养退住
 */
@Data
@Table(name = "nurseryRetreat")
public class NurseryRetreat extends FuLLBaseDateEntity {

    /**
     * 入托人Id
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.BIGINT)
    @IsNotNull
    private Long entrepreneurId;

    /**
     * 退住办理人
     */
    @Column(name = "retreatHandler", type = MySqlTypeConstant.VARCHAR,length = 50)
    @IsNotNull
    private String retreatHandler ;

    /**
     * 退住办理人联系方式
     */
    @Column(name = "retreatHandlerPhone", type = MySqlTypeConstant.VARCHAR,length = 20)
    @IsNotNull
    private String retreatHandlerPhone ;

    /**
     * 退住原因
     */
    @Column(name = "retreatReason", type = MySqlTypeConstant.VARCHAR,length = 2000)
    @IsNotNull
    private String retreatReason ;

    /**
     * 退住类型
     */
    @Column(name = "retreatType", type = MySqlTypeConstant.INT)
    @IsNotNull
    private RetreatType retreatType ;

    /**
     * 退住时间
     */
    @Column(name = "retreatTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private DateTime retreatTime ;
}

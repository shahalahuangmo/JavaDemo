package com.example.demo.system.model.domain.cost;

import cn.hutool.core.date.DateTime;
import com.example.demo.system.common.FuLLBaseDateEntity;
import com.example.demo.system.model.value.PaymentState;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsNotNull;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 费用清单
 */
@Data
@Table(name = "costBill")
public class CostBill extends FuLLBaseDateEntity {

    /**
     * 入托登记ID
     */
    @Column(name = "entrepreneurId", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Long entrepreneurId;
    /**
     * 账单日期
     */
    @Column(name = "billTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date billTime;
    /**
     * 账单总金额
     */
    @Column(name = "totalAmount", type = MySqlTypeConstant.DECIMAL,length = 10,decimalLength = 2)
    @IsNotNull
    private BigDecimal totalAmount;
    /**
     * 缴费状态
     */
    @Column(name = "paymentState", type = MySqlTypeConstant.INT)
    @IsNotNull
    private PaymentState paymentState;

    /**
     * 结算单号
     */
    @Column(name = "billCode", type = MySqlTypeConstant.VARCHAR, length = 50)
    @IsNotNull
    private String billCode;
    /**
     * 账单月份
     */
    @Column(name = "billMonth", type = MySqlTypeConstant.VARCHAR, length = 20)
    @IsNotNull
    private String billMonth;
    /**
     * 扣款时间
     */
    @Column(name = "paymentTime", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date paymentTime;
    /**
     * 结算开始日期
     */
    @Column(name = "startDate", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private Date startDate;
    /**
     * 结算结束日期
     */
    @Column(name = "endDate", type = MySqlTypeConstant.DATE)
    @IsNotNull
    private DateTime endDate;
    /**
     * 结算天数
     */
    @Column(name = "billDay", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer billDay;
    /**
     * 请假天数
     */
    @Column(name = "levelDay", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer levelDay;
    /**
     * 实住天数
     */
    @Column(name = "realDay", type = MySqlTypeConstant.INT)
    @IsNotNull
    private Integer realDay;
}

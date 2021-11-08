package com.example.spockdemo.entity;

import lombok.Data;

/**
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa
 * @Date 2021-11-07 11:05
 */
@Data
public class Order {
    private Integer id;
    private String orderNo;
    private Double amount;
    private String country;
    private Double exchangeAmount;
}

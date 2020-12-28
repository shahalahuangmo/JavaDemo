package com.pnf.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order  implements Serializable {

    private String orderCode;

    private String userId;

    private double price;

    private Integer size;
}

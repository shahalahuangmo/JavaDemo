package com.pnf.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAddress implements Serializable {
    private String id;
    private String Name;
    private String Address;
}

package com.example.spockdemo.entity;

import lombok.Data;

/**
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa
 * @Date 2021-11-02 21:53
 */
@Data
public class TestEntity {

    private Integer number;

    private String Name;

    public int method1() {
        return 1;
    }

    public String method2() {
        return "hello";
    }
}



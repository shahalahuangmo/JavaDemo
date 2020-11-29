package com.example.demo.system.model.value;

/**
 * 缴费状态
 */
public enum PaymentState {
    Unpaid ("未缴费", 1),
    Paid ("已缴费", 2),
    Invalid ("作废", 3);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private PaymentState(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

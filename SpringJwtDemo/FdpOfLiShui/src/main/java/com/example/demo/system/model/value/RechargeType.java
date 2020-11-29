package com.example.demo.system.model.value;

/**
 * 充值类型
 */
public enum RechargeType {
    Add ("预存记录", 1),
    Reduce ("清退记录", 2),
    Balance ("结余", 3),
    Settlement ("账单结算", 4);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private RechargeType(String name, int index) {
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

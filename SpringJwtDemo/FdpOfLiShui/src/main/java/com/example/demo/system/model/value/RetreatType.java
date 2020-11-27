package com.example.demo.system.model.value;

/**
 * 退住类型
 */
public enum RetreatType {
    RetreatAutonomously ("自主申请退托", 1),
    ForcedRetreat ("强制退住", 2),
    Incompatible ("不符合入住条件", 3);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private RetreatType(String name, int index) {
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

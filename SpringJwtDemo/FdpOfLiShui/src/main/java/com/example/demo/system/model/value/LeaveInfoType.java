package com.example.demo.system.model.value;

/**
 * 请假类型
 */
public enum LeaveInfoType {
    Description ("事假", 1),
    SickLeave ("病假", 2),
    Other ("其他", 3);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private LeaveInfoType(String name, int index) {
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

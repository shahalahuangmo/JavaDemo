package com.example.demo.system.model.value;

/**
 * 床位状态
 */
public enum BedStatus {
    Occupy ("占用", 1),
    Vacant ("空置", 2),
    maintain ("保养",3);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private BedStatus(String name, int index) {
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

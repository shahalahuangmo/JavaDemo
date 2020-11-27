package com.example.demo.system.model.value;

/**
 * 房屋质量
 */
public enum HouseQuality {
    Good ("好", 1),
    General ("一般", 2),
    DangerousHouse ("危房", 3),
    Other ("其他", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private HouseQuality(String name, int index) {
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

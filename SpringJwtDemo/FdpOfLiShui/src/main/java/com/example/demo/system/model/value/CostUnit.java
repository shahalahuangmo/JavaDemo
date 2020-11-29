package com.example.demo.system.model.value;

/**
 * 费用单位
 */
public enum CostUnit {
    Month ("月", 0),
    Day ("天", 1);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private CostUnit(String name, int index) {
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

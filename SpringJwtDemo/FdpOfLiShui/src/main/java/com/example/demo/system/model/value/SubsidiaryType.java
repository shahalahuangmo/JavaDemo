package com.example.demo.system.model.value;

/**
 * 低保类型
 */
public enum SubsidiaryType {
    None ("无", 0),
    LowIncomeHousehold ("低保户", 1),
    MinimumLivingEdge ("低保边缘户", 2);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private SubsidiaryType(String name, int index) {
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

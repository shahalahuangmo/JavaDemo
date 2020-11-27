package com.example.demo.system.model.value;

/**
 * 贫困类别
 */
public enum PovertyCategory {
    LowIncomeHousehold("低保户", 1),
    LowSecurityMargin("低保边缘", 2);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private PovertyCategory(String name, int index) {
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

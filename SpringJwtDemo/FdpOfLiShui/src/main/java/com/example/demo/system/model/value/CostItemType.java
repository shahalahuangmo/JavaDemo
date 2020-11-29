package com.example.demo.system.model.value;

/**
 * 费用项类型
 */
public enum CostItemType {
    Add ("收费项", 1),
    Reduce ("减免项", 2);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private CostItemType(String name, int index) {
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

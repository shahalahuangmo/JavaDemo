package com.example.demo.system.model.value;

/**
 * 残疾等级
 */
public enum DisabilityLevel {
    One ("一级", 1),
    Two ("二级", 2),
    Three ("三级", 3),
    Four ("四级", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private DisabilityLevel(String name, int index) {
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

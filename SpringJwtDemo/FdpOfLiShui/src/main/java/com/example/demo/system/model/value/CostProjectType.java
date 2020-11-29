package com.example.demo.system.model.value;

/**
 * 收费项目
 */
public enum CostProjectType {
    Bed ("床位费", 1),
    Nursing ("护理费", 2),
    Food ("伙食费", 3);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private CostProjectType(String name, int index) {
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

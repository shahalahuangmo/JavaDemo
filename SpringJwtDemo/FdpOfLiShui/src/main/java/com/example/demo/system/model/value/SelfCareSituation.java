package com.example.demo.system.model.value;

/**
 * 生活自理情况
 */
public enum SelfCareSituation {
    TakeCareItself("自理", 1),
    PartNotTakeCareItself("基本自理部分", 2),
    NotTakeCareItself("不能自理", 3),
    TotalDependenceOnOthers("完全依赖他人", 4);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private SelfCareSituation(String name, int index) {
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

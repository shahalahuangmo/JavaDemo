package com.example.demo.system.model.value;

/**
 * 护理补贴等级
 */
public enum NursingLevel {
    None("无", 0),
    FirstLevel("护理补贴一级", 1),
    TwoLevel("护理补贴二级", 2),
    ThreeLevel("护理补贴三级", 3),
    FourLevel("护理补贴四级", 4);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private NursingLevel(String name, int index) {
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

package com.example.demo.system.model.value;

/**
 * 性别
 */
public enum Gender {
    Unknown ("未知", 0),
    Male ("男", 1),
    Female ("女", 2);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private Gender(String name, int index) {
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

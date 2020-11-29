package com.example.demo.system.model.value;

/**
 * 事件级别
 */
public enum EventLevel {
    Ordinary ("普通", 1),
    HiddenDanger ("隐患", 2),
    Warning ("警告", 3),
    Serious ("严重", 4);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private EventLevel(String name, int index) {
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

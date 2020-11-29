package com.example.demo.system.model.value;

/**
 * 事件状态
 */
public enum EventState {
    Waiting ("待处理", 1),
    Processing ("处理中", 2),
    Processed ("已处理", 3);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private EventState(String name, int index) {
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

package com.example.demo.system.model.value;

/**
 * 护理状态
 */
public enum NursingStatus {
    NoDone ("否", 1),
    Done ("是", 2),
    Stop ("停止", 3);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private NursingStatus(String name, int index) {
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

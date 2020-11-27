package com.example.demo.system.model.value;

/**
 * 入住状态
 */
public enum CheckInStatus {
    TryCheckIn ("试住", 1),
    FormalCheckIn ("正式入托", 2),
    Leave ("请假", 3),
    Retreat ("退住", 4);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private CheckInStatus(String name, int index) {
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

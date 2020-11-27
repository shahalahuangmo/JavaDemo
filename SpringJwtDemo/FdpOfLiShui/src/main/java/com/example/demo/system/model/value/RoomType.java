package com.example.demo.system.model.value;

/**
 * 房间类型
 */
public enum RoomType {
    SingleRoom ("单人间", 1),
    DoubleRoom ("双人间", 2),
    TripleRoom ("三人间", 3),
    QuadrupleRoom ("四人间", 4);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private RoomType(String name, int index) {
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

package com.example.demo.system.model.value;

/**
 * 住房结构
 */
public enum HousingStructure {
    SimpleRoom ("简易房", 1),
    Bungalow ("平房", 2),
    DaZhai ("大寨屋", 3),
    TwoFloors ("二层楼", 4),
    ThreeFloors ("三层楼", 5),
    FourFloors ("四层楼", 6),
    FiveFloors ("五层楼", 7),
    WellOffType ("小康型", 8),
    Villa ("别墅", 9);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private HousingStructure(String name, int index) {
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

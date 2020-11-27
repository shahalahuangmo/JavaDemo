package com.example.demo.system.model.value;

/**
 * 户内人均使用面积
 */
public enum HousePerUseArea {
    FirstGearArea ("7m2以下", 1),
    SecondGearArea ("7m2-10m2", 2),
    ThirdGearArea ("11m2-15m2", 3),
    FourthGearArea ("16m2-20m2", 4),
    FifthGearArea ("21m2-30m2", 5),
    SixthGearArea ("30m2以上", 6);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private HousePerUseArea(String name, int index) {
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

package com.example.demo.system.model.value;

/**
 * 文化程度
 */
public enum EducationalLevel {
    Illiteracy("文盲", 1),
    PrimarySchool("小学", 2),
    MiddleSchool("初中", 3),
    HighSchool("高中", 4),
    SecondarySpecializedSchool("中专", 5),
    JuniorCollege("大专", 6),
    Undergraduate("本科", 7),
    Master("硕士", 8),
    Doctor("博士", 9),
    Other("其他", 10);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private EducationalLevel(String name, int index) {
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

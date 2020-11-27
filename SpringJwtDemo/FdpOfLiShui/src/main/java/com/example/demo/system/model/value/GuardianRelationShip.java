package com.example.demo.system.model.value;

/**
 * 残疾人与监护人关系
 */
public enum GuardianRelationShip {
    Unknown ("未知", 0),
    Spouse ("配偶", 1),
    Son ("子", 2),
    Female ("女", 3),
    Grandchild ("((外)孙(子/女)", 4),
    Parent ("父母", 5),
    Grandparents ("(外)祖父母", 6),
    Brother ("兄/弟/姐/妹", 7),
    Other ("其他", 8);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private GuardianRelationShip(String name, int index) {
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

package com.example.demo.system.model.value;

/**
 * 残疾人与联系人关系
 */
public enum ContactRelationShip {
    Spouse ("夫妻", 1),
    Child ("子女", 2),
    Parent ("父母", 3),
    Grandparents ("祖父母", 4),
    OuterGrandparents ("(外祖父母", 5),
    Brother ("兄弟姐妹", 6),
    Other ("其他", 7);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private ContactRelationShip(String name, int index) {
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

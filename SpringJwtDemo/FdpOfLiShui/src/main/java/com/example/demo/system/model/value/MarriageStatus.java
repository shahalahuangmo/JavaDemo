package com.example.demo.system.model.value;

/**
 * 婚姻状况
 */
public enum MarriageStatus {
    Unmarried ("未婚", 10),
    Married ("已婚", 20),
    Widowhood ("丧偶", 30),
    Divorce ("离婚", 40),
    Other ("其他", 90);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private MarriageStatus(String name, int index) {
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

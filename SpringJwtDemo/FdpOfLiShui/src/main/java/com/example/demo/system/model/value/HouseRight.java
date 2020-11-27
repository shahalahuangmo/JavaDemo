package com.example.demo.system.model.value;

/**
 * 产权
 */
public enum HouseRight {
    PropertyRights ("产权自有", 1),
    PropertyRightsOther ("产权他有", 2);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private HouseRight(String name, int index) {
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

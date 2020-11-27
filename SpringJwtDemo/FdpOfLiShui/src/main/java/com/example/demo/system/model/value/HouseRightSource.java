package com.example.demo.system.model.value;

/**
 * 产权来源
 */
public enum HouseRightSource {
    Inheritance ("继承遗产权", 1),
    CommercialHousing ("商品房", 2),
    RoomReform ("房改房", 3),
    SelfBuiltHouse ("自建房", 4),
    AffordableHousing ("经济适用房", 5),
    ParentRoom ("住父母房", 6),
    Lease ("租赁", 7),
    Borrow ("借用", 8),
    Other ("其他", 9);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private HouseRightSource(String name, int index) {
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

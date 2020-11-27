package com.example.demo.system.model.value;

/**
 * 收入来源
 */
public enum SourceIncome {
    Labor ("劳动", 1),
    Pension ("退休金", 2),
    LowSecurity ("低保金", 3),
    Realtor ("房屋租赁", 4),
    LandlessFarmerInsurance ("失地农民保险", 5),
    ParentalSupport ("父母抚养", 6),
    ChildAdoption ("子女瞻养", 7),
    FamilyAndFriends ("亲友资助", 8),
    Other ("其他", 9);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private SourceIncome(String name, int index) {
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

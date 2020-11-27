package com.example.demo.system.model.value;

/**
 * 个人月评价收入
 */
public enum AveragePersonalIncome {
    NoIncome("无收入",1),
    FirstClass("0元-220元（含220元）",1),
    SecondClass("221元-320元（含320元）",2),
    ThirdClass ("321元-800元（含800元）",3),
    FourthClass("801元-2000元（含2000元）",4),
    FifthClass("2001元以上",5);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private AveragePersonalIncome(String name, int index) {
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

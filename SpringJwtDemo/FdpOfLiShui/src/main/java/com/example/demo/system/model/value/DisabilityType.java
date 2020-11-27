package com.example.demo.system.model.value;

/**
 * 残疾类别
 */
public enum  DisabilityType {
    Vision ("视力障碍", 1),
    Hearing ("听力障碍", 2),
    Speech ("言语障碍", 3),
    Limbs ("肢体障碍", 4),
    Intelligence ("智力障碍", 5),
    Spirit ("精神障碍", 6),
    Multiple ("多重障碍", 7);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private DisabilityType(String name, int index) {
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

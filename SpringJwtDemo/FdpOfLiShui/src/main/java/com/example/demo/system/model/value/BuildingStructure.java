package com.example.demo.system.model.value;

/**
 * 建筑结构
 */
public enum BuildingStructure {
    BrickAndWoodStructure ("砖木结构", 1),
    WoodStructure ("木结构", 2),
    MixedStructure ("混合结构", 3),
    Rc ("钢筋混凝土", 4),
    SlateStructure ("石板结构", 5),
    OtherStructure ("其他", 6);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private BuildingStructure(String name, int index) {
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

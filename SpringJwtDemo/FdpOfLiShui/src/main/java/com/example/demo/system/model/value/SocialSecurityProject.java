package com.example.demo.system.model.value;

/**
 * 社会保险项目
 */
public enum SocialSecurityProject {
    Pension("养老保险", 1),
    MedicalInsurance("医疗保险", 2),
    UnemploymentInsurance("失业保险", 3),
    MaternityInsurance("生育保险", 4),
    InjuryInsurance("工伤保险", 5),
    BasicPensionInsurance("城乡居民基本养老保险", 6),
    BusinessInsurance("商业保险", 7),
    NewRuralInsurance("新农合保险", 8),
    LandExpropriatedPensionInsurance("失地农民养老保险", 9);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private SocialSecurityProject(String name, int index) {
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

package com.example.demo.system.model.value;

/**
 * 审核项目类型
 */
public enum AuditResult {
    PendingReview ("待审核", 1),
    AuditPassed ("通过", 2),
    AuditNotPassed ("不通过", 3);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private AuditResult(String name, int index) {
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

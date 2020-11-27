package com.example.demo.system.model.value;

/**
 * 审核项目类型
 */
public enum AuditProjectType {
    EnrollmentReview ("试住评估", 1),
    TraumaExamination ("外伤检查", 2),
    PhysicalExamination ("体检报告", 3),
    EnrollmentApplication ("入托申请", 4),
    LeaveInfo ("请假申请", 5);

    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private AuditProjectType(String name, int index) {
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

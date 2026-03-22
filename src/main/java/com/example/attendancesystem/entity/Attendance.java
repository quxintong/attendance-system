package com.example.attendancesystem.entity;

public class Attendance {
    private String studentId;  // 学号
    private String date;       // 日期
    private String status;     // 状态：正常、迟到、缺勤等
    private String remark;     // 备注

    // 无参构造
    public Attendance() {
    }

    // 带参构造
    public Attendance(String studentId, String date, String status, String remark) {
        this.studentId = studentId;
        this.date = date;
        this.status = status;
        this.remark = remark;
    }

    // Getter和Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
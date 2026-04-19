package com.example.attendancesystem.entity;

import java.time.LocalDateTime;

public class Attendance {
    private Long id;
    private String studentId;
    private String courseId;
    private LocalDateTime checkInTime;
    private Integer seatRow;
    private Integer seatCol;
    private String status;
    private LocalDateTime createTime;

    public Attendance() {}

    public Attendance(String studentId, String courseId, LocalDateTime checkInTime, Integer seatRow, Integer seatCol, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.checkInTime = checkInTime;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public LocalDateTime getCheckInTime() { return checkInTime; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }

    public Integer getSeatRow() { return seatRow; }
    public void setSeatRow(Integer seatRow) { this.seatRow = seatRow; }

    public Integer getSeatCol() { return seatCol; }
    public void setSeatCol(Integer seatCol) { this.seatCol = seatCol; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
package com.example.attendancesystem.entity;

public class Student {
    private String studentId;
    private String name;
    private Integer age;
    private String className;

    // 无参构造
    public Student() {
    }

    // 带参构造（方便创建对象）
    public Student(String studentId, String name, Integer age, String className) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    // Getter和Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
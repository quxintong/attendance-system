package com.example.attendancesystem.entity;

public class Student {
    private Long id;
    private String studentId;
    private String name;
    private String gender;
    private String className;

    public Student() {}

    public Student(String studentId, String name, String gender, String className) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.className = className;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
}
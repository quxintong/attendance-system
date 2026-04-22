package com.example.attendancesystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false, unique = true, length = 20)
    private String studentId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "gender", length = 2)
    private String gender;

    @Column(name = "class_name", length = 50)
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
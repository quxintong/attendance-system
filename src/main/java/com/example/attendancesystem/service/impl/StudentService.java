package com.example.attendancesystem.service;

import com.example.attendancesystem.entity.Student;
import java.util.List;

public interface StudentService {
    Student getStudentById(String studentId);
    List<Student> getStudentList(String name, String studentId);
}
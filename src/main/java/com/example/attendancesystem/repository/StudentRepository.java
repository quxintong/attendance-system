package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.Student;
import java.util.List;

public interface StudentRepository {
    Student save(Student student);
    Student findById(Long id);
    List<Student> findAll();
    void deleteById(Long id);
    Student findByStudentId(String studentId);
    List<Student> findByClassName(String className);
}
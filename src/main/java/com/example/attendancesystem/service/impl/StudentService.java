package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StudentService {
    Student save(Student student);
    Student findById(Long id);
    List<Student> findAll();
    void deleteById(Long id);
    Student findByStudentId(String studentId);
    List<Student> findByClassName(String className);
    Page<Student> findAll(Pageable pageable);
    Page<Student> searchByExample(String className, String name, Pageable pageable);
}
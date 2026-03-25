package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private List<Student> studentList = new ArrayList<>();

    public StudentServiceImpl() {
        studentList.add(new Student("42411127", "屈昕彤"));
        studentList.add(new Student("42411128", "张三"));
        studentList.add(new Student("42411129", "李四"));
        studentList.add(new Student("42411130", "王五"));
    }

    @Override
    public Student getStudentById(String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getStudentList(String name, String studentId) {
        List<Student> resultList = new ArrayList<>();

        for (Student student : studentList) {
            boolean match = true;

            if (studentId != null && !studentId.isEmpty()) {
                if (!student.getStudentId().equals(studentId)) {
                    match = false;
                }
            }

            if (name != null && !name.isEmpty()) {
                if (!student.getName().equals(name)) {
                    match = false;
                }
            }

            if (match) {
                resultList.add(student);
            }
        }

        return resultList;
    }
}
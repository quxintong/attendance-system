package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.common.Result;
import com.example.attendancesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/info")
    public String getStudentInfo() {
        return "姓名：屈昕彤，学号：42411127";
    }

    @PostMapping("/student/attendance")
    public String attendance(@RequestBody String studentId) {
        return "学号为 " + studentId + " 的学生打卡成功";
    }

    @GetMapping("/student/courses")
    public List<String> getCourses() {
        List<String> courses = new ArrayList<>();
        courses.add("java ee开发实践");
        courses.add("高数");
        courses.add("创新程序设计实践");
        return courses;
    }

    @GetMapping("/student/info/{studentId}")
    public Result<Student> getStudentByPath(@PathVariable String studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            return Result.error("未找到该学生");
        }
        return Result.success(student);
    }

    @GetMapping("/student/list")
    public Result<List<Student>> getStudentList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String studentId) {
        List<Student> studentList = studentService.getStudentList(name, studentId);
        return Result.success(studentList);
    }
}
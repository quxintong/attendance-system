package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.service.impl.StudentService;
import com.example.attendancesystem.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Result<Student> add(@RequestBody Student student) {
        Student saved = studentService.save(student);
        return Result.success(saved);
    }

    @GetMapping("/{id}")
    public Result<Student> findById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return student == null ? Result.error("未找到") : Result.success(student);
    }

    @GetMapping("/list")
    public Result<List<Student>> findAll() {
        return Result.success(studentService.findAll());
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return Result.success("删除成功");
    }

    @GetMapping("/studentId/{studentId}")
    public Result<Student> findByStudentId(@PathVariable String studentId) {
        Student student = studentService.findByStudentId(studentId);
        return student == null ? Result.error("未找到") : Result.success(student);
    }

    @GetMapping("/class/{className}")
    public Result<List<Student>> findByClassName(@PathVariable String className) {
        return Result.success(studentService.findByClassName(className));
    }
}
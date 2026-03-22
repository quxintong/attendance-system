package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.common.Result;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // ===== 原有的接口 =====

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
        Student student = new Student();
        student.setStudentId(studentId);
        student.setName("屈昕彤");
        return Result.success(student);
    }


    @GetMapping("/student/list")
    public Result<List<Student>> getStudentList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String studentId) {

        System.out.println("获取到的参数：name: " + name + ", studentId: " + studentId);

        List<Student> allStudents = new ArrayList<>();

        Student s1 = new Student();
        s1.setStudentId("42411127");
        s1.setName("屈昕彤");
        allStudents.add(s1);

        Student s2 = new Student();
        s2.setStudentId("42411128");
        s2.setName("张三");
        allStudents.add(s2);

        Student s3 = new Student();
        s3.setStudentId("42411129");
        s3.setName("李四");
        allStudents.add(s3);

        List<Student> resultList = new ArrayList<>();

        for (Student student : allStudents) {
            boolean match = true;

            // 如果传了学号参数，检查学号是否匹配
            if (studentId != null && !studentId.isEmpty()) {
                if (!student.getStudentId().equals(studentId)) {
                    match = false;
                }
            }

            // 如果传了姓名参数，检查姓名是否匹配
            if (name != null && !name.isEmpty()) {
                if (!student.getName().equals(name)) {
                    match = false;
                }
            }

            // 如果所有条件都匹配，加入结果列表
            if (match) {
                resultList.add(student);
            }
        }

        // 3. 返回结果
        return Result.success(resultList);
    }
}
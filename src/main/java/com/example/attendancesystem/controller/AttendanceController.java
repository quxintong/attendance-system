package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Attendance;
import com.example.attendancesystem.service.impl.AttendanceService;
import com.example.attendancesystem.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/add")
    public Result<Attendance> add(@RequestBody Attendance attendance) {
        Attendance saved = attendanceService.save(attendance);
        return Result.success(saved);
    }

    @GetMapping("/{id}")
    public Result<Attendance> findById(@PathVariable Long id) {
        Attendance attendance = attendanceService.findById(id);
        return attendance == null ? Result.error("未找到") : Result.success(attendance);
    }

    @GetMapping("/list")
    public Result<List<Attendance>> findAll() {
        return Result.success(attendanceService.findAll());
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteById(@PathVariable Long id) {
        attendanceService.deleteById(id);
        return Result.success("删除成功");
    }

    @GetMapping("/student/{studentId}")
    public Result<List<Attendance>> findByStudentId(@PathVariable String studentId) {
        return Result.success(attendanceService.findByStudentId(studentId));
    }

    @GetMapping("/course/{courseId}")
    public Result<List<Attendance>> findByCourseId(@PathVariable String courseId) {
        return Result.success(attendanceService.findByCourseId(courseId));
    }
}
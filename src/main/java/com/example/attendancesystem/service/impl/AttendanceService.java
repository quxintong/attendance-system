package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.Attendance;
import java.util.List;

public interface AttendanceService {
    Attendance save(Attendance attendance);
    Attendance findById(Long id);
    List<Attendance> findAll();
    void deleteById(Long id);
    List<Attendance> findByStudentId(String studentId);
    List<Attendance> findByCourseId(String courseId);
}
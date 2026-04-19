package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.Attendance;
import com.example.attendancesystem.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance findById(Long id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public List<Attendance> findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public List<Attendance> findByStudentId(String studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    @Override
    public List<Attendance> findByCourseId(String courseId) {
        return attendanceRepository.findByCourseId(courseId);
    }
}
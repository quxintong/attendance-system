package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AttendanceRepositoryImpl implements AttendanceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Attendance save(Attendance attendance) {
        String sql = "INSERT INTO attendance (student_id, course_id, check_in_time, seat_row, seat_col, status) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                attendance.getStudentId(),
                attendance.getCourseId(),
                attendance.getCheckInTime(),
                attendance.getSeatRow(),
                attendance.getSeatCol(),
                attendance.getStatus());
        return attendance;
    }

    @Override
    public Attendance findById(Long id) {
        String sql = "SELECT * FROM attendance WHERE id = ?";
        List<Attendance> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Attendance.class), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Attendance> findAll() {
        String sql = "SELECT * FROM attendance";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Attendance.class));
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM attendance WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Attendance> findByStudentId(String studentId) {
        String sql = "SELECT * FROM attendance WHERE student_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Attendance.class), studentId);
    }

    @Override
    public List<Attendance> findByCourseId(String courseId) {
        String sql = "SELECT * FROM attendance WHERE course_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Attendance.class), courseId);
    }
}
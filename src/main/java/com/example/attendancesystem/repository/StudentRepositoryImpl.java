package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student save(Student student) {
        String sql = "INSERT INTO student (student_id, name, gender, class_name) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getStudentId(), student.getName(), student.getGender(), student.getClassName());
        return student;
    }

    @Override
    public Student findById(Long id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM student WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Student findByStudentId(String studentId) {
        String sql = "SELECT * FROM student WHERE student_id = ?";
        List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), studentId);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Student> findByClassName(String className) {
        String sql = "SELECT * FROM student WHERE class_name = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), className);
    }
}
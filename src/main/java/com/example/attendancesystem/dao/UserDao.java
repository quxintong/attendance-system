package com.example.attendancesystem.dao;

import com.example.attendancesystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(User user) {
        String sql = "INSERT INTO [user] (username, password, real_name, role) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRealName(), user.getRole());
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM [user] WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM [user] WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
    }

    public List<User> findAllTeachers() {
        String sql = "SELECT * FROM [user] WHERE role = 'TEACHER'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM [user]";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public void update(User user) {
        String sql = "UPDATE [user] SET password = ?, real_name = ?, role = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getPassword(), user.getRealName(), user.getRole(), user.getId());
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM [user] WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.User;
import java.util.List;

public interface UserService {
    void insert(User user);
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAllTeachers();
    List<User> findAll();
    void update(User user);
    void deleteById(Long id);
}
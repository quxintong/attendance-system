package com.example.attendancesystem.controller;

import com.example.attendancesystem.dao.UserDao;
import com.example.attendancesystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/test-user")
    public String testUser() {
        User user = new User("test001", "123", "测试用户", "STUDENT");
        userDao.insert(user);
        return "用户插入成功";
    }
}
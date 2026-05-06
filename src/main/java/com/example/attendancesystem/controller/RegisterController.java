package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.User;
import com.example.attendancesystem.repository.UserRepository;
import com.example.attendancesystem.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Result<String> register(@RequestBody User user) {
        // 检查用户名是否已存在
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            return Result.error("用户名已存在");
        }

        // 保存用户
        user.setRole("STUDENT");
        userRepository.save(user);

        return Result.success("注册成功");
    }
}
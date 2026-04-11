package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.User;
import com.example.attendancesystem.service.impl.UserService;
import com.example.attendancesystem.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public Result<String> insert(@RequestBody User user) {
        userService.insert(user);
        return Result.success("用户添加成功");
    }

    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return Result.success(user);
    }

    @GetMapping("/username/{username}")
    public Result<User> findByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return Result.success(user);
    }

    @GetMapping("/teachers")
    public Result<List<User>> findAllTeachers() {
        return Result.success(userService.findAllTeachers());
    }

    @GetMapping("/list")
    public Result<List<User>> findAll() {
        return Result.success(userService.findAll());
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody User user) {
        userService.update(user);
        return Result.success("用户更新成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return Result.success("用户删除成功");
    }
}
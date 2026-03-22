package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Attendance;
import com.example.attendancesystem.common.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    // 任务三：考勤记录更新接口
    @PostMapping("/update")
    public Result<String> updateAttendance(@RequestBody Attendance attendance) {
        // 打印接收到的考勤记录（方便调试）
        System.out.println("===== 接收到考勤记录 =====");
        System.out.println("学号：" + attendance.getStudentId());
        System.out.println("日期：" + attendance.getDate());
        System.out.println("状态：" + attendance.getStatus());
        System.out.println("备注：" + attendance.getRemark());
        System.out.println("=========================");

        // 返回成功消息
        return Result.success("考勤记录更新成功");
    }
}
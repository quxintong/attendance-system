package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 学生列表页面（带搜索、排序、分页）
    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int size,
                       @RequestParam(required = false) String keyword,
                       @RequestParam(defaultValue = "id") String sortField,
                       @RequestParam(defaultValue = "asc") String sortDirection,
                       Model model) {

        Sort sort = sortDirection.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<Student> studentPage;

        if (keyword != null && !keyword.isEmpty()) {
            studentPage = studentService.search(keyword, pageable);
            model.addAttribute("keyword", keyword);
        } else {
            studentPage = studentService.findAll(pageable);
        }

        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", studentPage.getTotalPages());
        model.addAttribute("totalElements", studentPage.getTotalElements());
        model.addAttribute("size", size);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);

        return "student-list";
    }

    // 新增学生页面
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // 编辑学生页面
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student-form";
    }

    // 保存学生（带验证）
    @PostMapping("/save")
    public String save(@ModelAttribute Student student, Model model) {
        // 验证学号是否已存在
        Student existing = studentService.findByStudentId(student.getStudentId());
        if (existing != null && !existing.getId().equals(student.getId())) {
            model.addAttribute("error", "学号已存在");
            model.addAttribute("student", student);
            return "student-form";
        }

        // 验证必填字段
        if (student.getStudentId() == null || student.getStudentId().isEmpty()) {
            model.addAttribute("error", "学号不能为空");
            model.addAttribute("student", student);
            return "student-form";
        }
        if (student.getName() == null || student.getName().isEmpty()) {
            model.addAttribute("error", "姓名不能为空");
            model.addAttribute("student", student);
            return "student-form";
        }

        studentService.save(student);
        return "redirect:/student/list";
    }

    // 删除学生
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/student/list";
    }

    // 批量删除
    @GetMapping("/batchDelete")
    public String batchDelete(@RequestParam String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            studentService.deleteById(Long.parseLong(id));
        }
        return "redirect:/student/list";
    }
}
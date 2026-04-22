package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Student> findByClassName(String className) {
        return studentRepository.findByClassName(className);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> searchByExample(String className, String name, Pageable pageable) {
        Student probe = new Student();
        if (className != null && !className.isEmpty()) {
            probe.setClassName(className);
        }
        if (name != null && !name.isEmpty()) {
            probe.setName(name);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("className", ExampleMatcher.GenericPropertyMatchers.exact());

        Example<Student> example = Example.of(probe, matcher);
        return studentRepository.findAll(example, pageable);
    }
}
package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
    Student findByStudentId(String studentId);
    List<Student> findByClassName(String className);

    <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable);
}
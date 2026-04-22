package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.Student;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class StudentSpecification {

    public static Specification<Student> search(String className, String name) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (className != null && !className.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("className"), className));
            }

            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
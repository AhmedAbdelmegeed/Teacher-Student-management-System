package com.abdelmegeed.teacherstudentmanegmentsystem.student.repo;

import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findByUser_Username(String username);

}

package com.abdelmegeed.teacherstudentmanegmentsystem.student.repo;

import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}

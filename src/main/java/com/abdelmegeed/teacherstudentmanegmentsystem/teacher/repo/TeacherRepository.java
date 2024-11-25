package com.abdelmegeed.teacherstudentmanegmentsystem.teacher.repo;

import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
    Optional<Teacher> findByUser_Username(String username);
}

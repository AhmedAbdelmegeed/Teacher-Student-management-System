package com.abdelmegeed.teacherstudentmanegmentsystem.teacher.repo;

import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}

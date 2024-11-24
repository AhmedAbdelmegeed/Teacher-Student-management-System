package com.abdelmegeed.teacherstudentmanegmentsystem.course.repo;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

}

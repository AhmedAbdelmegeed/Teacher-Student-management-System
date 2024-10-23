package com.abdelmegeed.teacherstudentmanegmentsystem.repository;

import com.abdelmegeed.teacherstudentmanegmentsystem.model.course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface courseRepository extends JpaRepository<course, Long> {
    List<course> findByUser_Id(Long userId);
}

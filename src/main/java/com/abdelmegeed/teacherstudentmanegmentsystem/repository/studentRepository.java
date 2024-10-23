package com.abdelmegeed.teacherstudentmanegmentsystem.repository;

import com.abdelmegeed.teacherstudentmanegmentsystem.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface studentRepository extends JpaRepository<user, Long> {
    List<user> findByRole(String role);
}

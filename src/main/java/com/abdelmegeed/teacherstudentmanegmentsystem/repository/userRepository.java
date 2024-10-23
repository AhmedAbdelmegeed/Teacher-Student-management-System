package com.abdelmegeed.teacherstudentmanegmentsystem.repository;

import com.abdelmegeed.teacherstudentmanegmentsystem.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
public interface userRepository extends JpaRepository<user,Long> {
    user findByEmail(String email);
    user findByEmailAndRole(String username, String role);
}

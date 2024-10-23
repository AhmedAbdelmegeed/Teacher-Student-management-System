package com.abdelmegeed.teacherstudentmanegmentsystem.service;

import com.abdelmegeed.teacherstudentmanegmentsystem.model.role;
import com.abdelmegeed.teacherstudentmanegmentsystem.model.user;
import com.abdelmegeed.teacherstudentmanegmentsystem.repository.teacherRepository;
import com.abdelmegeed.teacherstudentmanegmentsystem.repository.studentRepository;
import com.abdelmegeed.teacherstudentmanegmentsystem.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    private userRepository userRepository;
    private final teacherRepository teacherRepository;
    private final studentRepository studentRepository;

    @Autowired
    public userService(teacherRepository teacherRepository, studentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }
    public user authenticateUser(String email, String password, role role) {
        // Fetch user from repository by email and role
        user user = userRepository.findByEmailAndRole(email, role.name());
        if (user != null && user.getPassword().equals(password)) {
            return user;  // Successfully authenticated
        }
        return null;  // Authentication failed
    }

    public List<user> getAllTeachers() {
        return teacherRepository.findByRole("TEACHER");
    }

    public List<user> getAllStudents() {
        return studentRepository.findByRole("STUDENT");
    }

    public void saveUser(user user) {
        if ("TEACHER".equalsIgnoreCase(user.getRole())) {
            teacherRepository.save(user);
        } else {
            studentRepository.save(user);
        }
    }

    public user save(user user) {
        return userRepository.save(user);
    }

    public List<user> findAll() {
        return userRepository.findAll();
    }

    public user findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

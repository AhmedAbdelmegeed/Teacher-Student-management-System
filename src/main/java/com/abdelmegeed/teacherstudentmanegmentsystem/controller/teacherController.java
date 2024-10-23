package com.abdelmegeed.teacherstudentmanegmentsystem.controller;

import com.abdelmegeed.teacherstudentmanegmentsystem.model.user;
import com.abdelmegeed.teacherstudentmanegmentsystem.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class teacherController {
    @Autowired
    private userService userService;

    @GetMapping("/teachers")
    public String getAllTeachers() {
        List<user> teachers = userService.findAll();
        return "teacher_home";
    }
}

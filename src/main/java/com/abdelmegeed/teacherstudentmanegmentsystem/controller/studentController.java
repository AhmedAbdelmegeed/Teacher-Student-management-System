package com.abdelmegeed.teacherstudentmanegmentsystem.controller;
import com.abdelmegeed.teacherstudentmanegmentsystem.model.user;
import com.abdelmegeed.teacherstudentmanegmentsystem.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class studentController {
    @Autowired
    private userService userService;

    @GetMapping("/students")
    public String getAllStudents() {
        List<user> students = userService.findAll();
        return "student_home";
    }
}

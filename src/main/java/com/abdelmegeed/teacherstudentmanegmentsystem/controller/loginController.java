package com.abdelmegeed.teacherstudentmanegmentsystem.controller;

import com.abdelmegeed.teacherstudentmanegmentsystem.model.user;
import com.abdelmegeed.teacherstudentmanegmentsystem.model.role;
import com.abdelmegeed.teacherstudentmanegmentsystem.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class loginController {
    private final userService userService;

    @Autowired
    public loginController(userService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showLandingPage() {
        return "index";  // Renders index.html
    }

    @GetMapping("/teacherHome")
    public String redirectTeacherHome() {

        return "teacherHome";
    }

    @GetMapping("/studentHome")
    public String redirectStudentHome() {
        return "studentHome";
    }


    @GetMapping("/teacherLogin")
    public String showTeacherLogin(Model model) {
        model.addAttribute("user", new user());
        return "teacherLogin";
    }

    @GetMapping("/studentLogin")
    public String showStudentLogin(Model model) {
        model.addAttribute("user", new user());
        return "studentLogin";
    }

    // Handle Teacher login and redirect to Teacher home page
    @PostMapping("/teacherHome")
    public String redirectTeacherHome(@ModelAttribute("user") user user, Model model) {
        user authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword(), role.TEACHER);
        if (authenticatedUser == null) {
            model.addAttribute("error", "Invalid teacher credentials");
            return "teacherLogin";
        }
        return "teacherHome";
    }

    // Handle Student login and redirect to Student home page
    @PostMapping("/studentHome")
    public String redirectStudentHome(@ModelAttribute("user") user user, Model model) {
        user authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword(), role.STUDENT);
        if (authenticatedUser == null) {
            model.addAttribute("error", "Invalid student credentials");
            return "studentLogin";
        }
        return "studentHome";
    }
}
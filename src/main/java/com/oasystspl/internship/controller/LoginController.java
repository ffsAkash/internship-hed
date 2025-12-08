package com.oasystspl.internship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login() {
        return "student-dashboard";
    }

    @PostMapping("/login/verify_ajax/user")
    @ResponseBody
    public Map<String, Object> verifyLogin() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("successPage", "/student/dashboard");
        map.put("first_year_campaign", false);
        map.put("name", "Aradhana Behera");
        map.put("role", "student");
        map.put("email", "ajfrek3@gmail.com");
        return map;
    }

    @PostMapping("/registration/employer_submit")
    @ResponseBody
    public Map<String, Object> verifyEmployerRegistration() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("successPage", "/employer/dashboard");
        return map;
    }

    @PostMapping("/registration/student_submit")
    @ResponseBody
    public Map<String, Object> verifyStudentRegistration() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("successPage", "/student/dashboard");
        return map;
    }

    //For Student
    @GetMapping("/registration/verify_email")
    public String verifyEmail() {
        return "student-verify-email";
    }

    @PostMapping("/registration/verify_email")
    public String verifyEmailSubmit() {
        return "redirect:/student/dashboard";
    }
}

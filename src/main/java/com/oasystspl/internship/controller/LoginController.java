package com.oasystspl.internship.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String userType,   // This comes from hidden field
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        // Create session
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", email);
        session.setAttribute("userType", userType);

        // Redirect based on userType
        return switch (userType) {
            case "student" -> "redirect:/student/dashboard";
            case "college" -> "redirect:/admin/dashboard";   // you said college → admin
            case "mentor"  -> "redirect:/mentor/dashboard";
            default        -> "redirect:/student/dashboard";
        };
    }

    @PostMapping("/login/verify_ajax/user")
    @ResponseBody
    public Map<String, Object> verifyLogin(
            @RequestParam String userType) {   // This comes from the hidden field

        Map<String, Object> response = new HashMap<>();

        // Common data
        response.put("success", true);
        response.put("first_year_campaign", false);
        response.put("name", "Aradhana Behera");        // You can make this dynamic later
        response.put("email", "ajfrek3@gmail.com");     // Same here if needed

        // Dynamic redirect page + role based on selected tab
        switch (userType) {
            case "student" -> {
                response.put("successPage", "/student/dashboard");
                response.put("role", "student");
            }
            case "college" -> {
                response.put("successPage", "/admin/dashboard");
                response.put("role", "college");
            }
            case "mentor" -> {
                response.put("successPage", "/mentor/dashboard");
                response.put("role", "mentor");
            }
            default -> {
                response.put("successPage", "/student/dashboard");
                response.put("role", "student");
            }
        }

        return response;
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
    @PostMapping("/student/registration")
    public String reg() {
        return "redirect:/student/verify_email";
    }

    @PostMapping("/registration/verify_email")
    public String verifyEmailSubmit() {
        return "redirect:/student/dashboard";
    }


}

package com.oasystspl.internship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @PostMapping("/login")
    public String login() {
        return "redirect:/employer/dashboard";
    }

    @GetMapping("/registration")
    public String register() {
        return "emp-registration";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "emp-dashboard";
    }

    @GetMapping("/registration/verify_email")
    public String verifyEmail() {
        return "emp-verify-email";
    }

    @PostMapping("/registration/verify_email")
    public String verifyEmailSubmit() {
        return "redirect:/employer/registration/profile";
    }

    @GetMapping("/registration/profile")
    public String profile() {
        return "emp-profile";
    }

    @GetMapping("/registration/organization")
    public String organization() {
        return "emp-organization-details";
    }

    @GetMapping("/registration/internship")
    public String internship() {
        return "emp-post-internship";
    }

    @GetMapping("/post-internship")
    public String postInternship() {
        return "post-internship";
    }
}

package com.oasystspl.internship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @GetMapping("/register")
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
        return "emp-profile";
    }
}

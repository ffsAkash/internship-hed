package com.oasystspl.internship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "student-dashboard";
    }

    @GetMapping("/all-internships")
    public String allInternships() {
        return "all-internships";
    }

    @GetMapping("/internship-by-location")
    public String internshipByLocation(@RequestParam String location) {
        if ("hyderabad".equals(location)) {
            return "internship-in-hyderabad";
        } else if ("bangalore".equals(location)) {
            return "internship-in-bangalore";
        } else if ("delhi".equals(location)) {
            return "internship-in-delhi";
        }

        return "redirect:/error";
    }

    @GetMapping("/internship-by-category")
    public String internshipByCategory(@RequestParam String category) {
        if ("engineering".equals(category)) {
            return "engineering-internships";
        } else if ("mba".equals(category)) {
            return "mba-internships";
        } else if ("humanities".equals(category)) {
            return "humanities-internships";
        }

        return "redirect:/error";
    }


    @GetMapping("/internship-by-profile")
    public String internshipByProfile(@RequestParam String profile) {
        if ("cs".equals(profile)) {
            return "cs-internships";
        } else if ("marketing".equals(profile)) {
            return "marketing-internships";
        } else if ("finance".equals(profile)) {
            return "finance-internships";
        }

        return "redirect:/error";
    }

}

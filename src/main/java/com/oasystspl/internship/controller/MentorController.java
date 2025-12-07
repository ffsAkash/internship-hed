package com.oasystspl.internship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentor")
public class MentorController {
	
	@GetMapping("/dashboard")
    public String dashboard() {
        return "mentor-dashboard";
    }

	@GetMapping("/mystudent")
    public String mystudent() {
        return "mentor-mystudent";
    }

	@GetMapping("/attendance")
    public String attendance() {
        return "mentor-attendance";
    }

	@GetMapping("/evaluation")
    public String evaluation() {
        return "mentor-evaluation";
    }


}

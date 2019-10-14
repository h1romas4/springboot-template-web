package com.example.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class DashboardController {
    protected static Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @GetMapping("/admin/dashboard")
    String home(Model model) {
        return "dashboard";
    }
}

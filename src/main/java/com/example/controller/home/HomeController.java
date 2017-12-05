package com.example.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {
    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("message", "こんにちは。");
        return "home";
    }
}

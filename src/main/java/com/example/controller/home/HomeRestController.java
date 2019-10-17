package com.example.controller.home;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeRestController
 */
@RestController
class HomeRestController {
    @GetMapping("/vue")
    List<String> home(Model model) {
        return List.of("Hello,", "Vue.js", "world.");
    }
}

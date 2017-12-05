package com.example.controller.home;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeRestController {
    @GetMapping("/vue")
    List<String> home(Model model) {
        return new ArrayList<String>() {
            { add("Hello,"); }
            { add("Vue.js"); }
            { add("world."); }
        };
    }
}

package com.example.controller.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeRestController
 */
@RestController
class HomeRestController {
    private final static Logger logger = LoggerFactory.getLogger(HomeRestController.class);

    @GetMapping("/vue")
    List<String> home(Model model) {
        logger.debug("@HomeRestController");

        return List.of("Hello,", "Vue.js", "world.");
    }
}

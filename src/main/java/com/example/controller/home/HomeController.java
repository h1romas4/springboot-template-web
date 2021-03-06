package com.example.controller.home;

import java.util.Locale;

import com.example.config.Setting;
import com.example.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 */
@Controller
class HomeController {
    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Setting setting;

    @GetMapping("/")
    String home(Model model) {
        // debug log sample
        logger.debug("@debug message");

        // see resources/message.properties
        model.addAttribute("message",
            messageSource.getMessage("hello.world", new String[] { "Spring", "Boot" }, Locale.JAPAN));

        // see resources/application.yml and com.example.Setting
        model.addAttribute("setting", setting.getSiteUrl());

        // DB select test
        model.addAttribute("users", userService.get());

        // see resources/static/templates/hello.html
        return "home";
    }
}

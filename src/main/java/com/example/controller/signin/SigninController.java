package com.example.controller.signin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class SigninController {
    private final static Logger logger = LoggerFactory.getLogger(SigninController.class);

    @RequestMapping("/signin")
    String signin() {
        logger.debug("@SigninController");

        return "signin";
    }
}

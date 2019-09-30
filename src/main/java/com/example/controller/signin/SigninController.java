package com.example.controller.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class SigninController {
    @RequestMapping("/signin")
    String signin() {
        return "signin";
    }
}

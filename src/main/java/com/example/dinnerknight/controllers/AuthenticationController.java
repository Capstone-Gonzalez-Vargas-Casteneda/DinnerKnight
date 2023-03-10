package com.example.dinnerknight.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(){
        return "users/login";
    }

    @GetMapping("/about")
    public String aboutUs(){
        return "/aboutus";
    }

    @GetMapping("/api/tester")
    public String apiTest(){
        return "/jsTester";
    }
}

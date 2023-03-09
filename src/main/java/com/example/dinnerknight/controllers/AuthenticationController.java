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

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password){
//        if (username.equals("admin") && password.equals("password")) {
//            return "redirect:/profile";
//        }
//        return "redirect:/login?error";
//    }
}

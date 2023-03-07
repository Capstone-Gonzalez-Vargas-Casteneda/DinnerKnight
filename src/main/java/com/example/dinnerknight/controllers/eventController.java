package com.example.dinnerknight.controllers;

import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class eventController {

    private final UserRepository userDao;

    public eventController(UserRepository userDao){
        this.userDao = userDao;
    }
}

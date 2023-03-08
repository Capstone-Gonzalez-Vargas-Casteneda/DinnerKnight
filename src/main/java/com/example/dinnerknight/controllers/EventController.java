package com.example.dinnerknight.controllers;

import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class EventController {

    private final UserRepository userDao;

    public EventController(UserRepository userDao){
        this.userDao = userDao;
    }
}

package com.example.dinnerknight.controllers;

import com.example.dinnerknight.repositories.PackRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    private final PackRepository packDao;

    private final FoodRepository foodDao;

    private final EventRepository eventDao;


    public EventController(PackRepository packDao, FoodRepository foodDao , EventRepository eventDao){
        this.packDao = packDao;
        this.foodDao = foodDao;
        this.eventDao = eventDao;
    }

    @GetMapping
    public String eventsHome(Model model){
        model.addAttribute("events" , eventDao.findAllById());//need to find a way to grab logged in users group ID to see proper events.
        return "/events/index";
    }
}

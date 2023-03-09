package com.example.dinnerknight.controllers;

import com.example.dinnerknight.models.Event;
import com.example.dinnerknight.repositories.EventRepository;
import com.example.dinnerknight.repositories.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {


    private final FoodRepository foodDao;

    private final EventRepository eventDao;


    public EventController(FoodRepository foodDao , EventRepository eventDao){
        this.foodDao = foodDao;
        this.eventDao = eventDao;
    }

    @GetMapping("/events/create")
    public String eventForm(Model model){
        model.addAttribute("event", new Event());
        return "events/create";
    }

//    @PostMapping("/events/save")
//    public String saveEvent(@ModelAttribute Event event){
//
//    }
}

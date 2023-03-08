package com.example.dinnerknight.controllers;

import com.example.dinnerknight.models.Event;
import com.example.dinnerknight.models.User;
import com.example.dinnerknight.repositories.EventRepository;
import com.example.dinnerknight.repositories.FoodRepository;
import com.example.dinnerknight.repositories.PackRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/events/create")
    public String eventForm(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user.isCook()){
            model.addAttribute("event", new Event());
            return "events/create";
        }
        return "groups/profile";
    }

//    @PostMapping("/events/save")
//    public String saveEvent(@ModelAttribute Event event){
//
//    }
}

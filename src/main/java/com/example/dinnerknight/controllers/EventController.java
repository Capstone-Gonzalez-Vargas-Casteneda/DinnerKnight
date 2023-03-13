package com.example.dinnerknight.controllers;

import com.example.dinnerknight.models.Event;
import com.example.dinnerknight.models.Food;
import com.example.dinnerknight.models.User;
import com.example.dinnerknight.repositories.EventRepository;
import com.example.dinnerknight.repositories.FoodRepository;
import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    private final UserRepository userDao;

    private final FoodRepository foodDao;

    private final EventRepository eventDao;


    public EventController(UserRepository userDao,FoodRepository foodDao , EventRepository eventDao){
        this.userDao = userDao;
        this.foodDao = foodDao;
        this.eventDao = eventDao;
    }

    @GetMapping("/events")
    public String eventIndex(Model model){
        model.addAttribute("events", eventDao.findAll());
        return "events/index";
    }

    @GetMapping("/events/{id}")
    public String eventShow(Model model ,@PathVariable long id){
        model.addAttribute("event",eventDao.findEventById(id));
        return "events/show";
    }

    @GetMapping("/events/create")
    public String eventForm(Model model){
        model.addAttribute("event", new Event());
        return "events/create";
    }

    @PostMapping("/events/save")
    public String saveEvent(@ModelAttribute Event event){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Food grub = foodDao.findFoodById(1);
        event.setOwner(user);
        event.setFood(grub);
        eventDao.save(event);
        return "redirect:/events";
    }

    @GetMapping("events/{id}/edit")
    public String editEvent(Model model, @PathVariable long id){
        Event ogEvent = eventDao.findEventById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(user.getId() == ogEvent.getOwner().getId()){
            model.addAttribute("event", eventDao.findEventById(id));
            return "events/create";
        }
        return "redirect:/events";
    }

    @GetMapping("events/{id}/join")
    public String joinEvent(@PathVariable long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Event desiredEvent = eventDao.findEventById(id);
        if(!user.getEvents().contains(desiredEvent)){
            user.addEvent(desiredEvent);
        }

        return "redirect:/events/" + id ;
    }

    @GetMapping("/events/{id}/delete")
    public String deleteEvent(@PathVariable long id) {
        Event goodbye = eventDao.findEventById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if( user.getId() == goodbye.getOwner().getId()){
            eventDao.delete(goodbye);
            return "redirect:/events";
        }

        return "redirect:/events";
    }
}

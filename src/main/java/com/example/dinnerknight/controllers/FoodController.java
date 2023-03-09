package com.example.dinnerknight.controllers;

import com.example.dinnerknight.models.Food;
import com.example.dinnerknight.repositories.EventRepository;
import com.example.dinnerknight.repositories.FoodRepository;
import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoodController {
    private final UserRepository userDao;
    private final EventRepository eventDao;
    private final FoodRepository foodDao;

    public FoodController(UserRepository userDao, EventRepository eventDao, FoodRepository foodDao) {
        this.userDao = userDao;
        this.eventDao = eventDao;
        this.foodDao = foodDao;
    }

    @GetMapping("/foods")
    public String foodForm(){
        return "food";
    }

    @GetMapping("/foods/create")
    public String addFoodForm(Model model){
        model.addAttribute("food", new Food());
        return "food/create";
    }

}



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
import org.springframework.web.bind.annotation.*;

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
    public String foodForm() {
        return "foods/index";
    }

    @GetMapping("/foods/create")
    public String addFoodForm(Model model) {
        model.addAttribute("food", new Food());
        return "foods/create";
    }

    @GetMapping("/foods/save")
    public String saveFood(@ModelAttribute Food food) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Event eventFood = eventDao.findEventById(1);
        foodDao.save(food);
        return "redirect:/foods";
    }

    @GetMapping("/food/{id}/edit")
    public String editFood(Model model, @PathVariable long id) {
        Food food = foodDao.findFoodById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId() == food.getId()) {
            model.addAttribute("food", foodDao.findFoodById(id));
            return "foods/create";
        }
        return "redirect:/foods/index";
    }

    @GetMapping("/food/{id}/delete")
    public String deleteFood(@PathVariable long id) {
        Food noEat = foodDao.findFoodById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId() == noEat.getId()) {
            foodDao.delete(noEat);
            return "redirect:/foods";
        }
        return "redirect:/foods";
    }
}



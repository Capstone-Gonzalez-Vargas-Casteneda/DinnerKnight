package com.example.dinnerknight.controllers;

import com.example.dinnerknight.models.Pack;
import com.example.dinnerknight.repositories.PackRepository;
import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PackController {

    private final UserRepository userDao;

    private final PackRepository packDao;

    public PackController(UserRepository userDao, PackRepository packDao){
        this.userDao = userDao;
        this.packDao = packDao;
    }

    @GetMapping("/pack/register")
    public String ShowPackRegisterForm( Model model){
        model.addAttribute("pack", new Pack());
        return "";
    }

    @PostMapping("/pack/register")
    public String savePack(@ModelAttribute Pack pack){
        long cook_id = userDao.getById() // need to find a way to grab the id from the sessions user.
        pack.setCook_id(cook_id);
        packDao.save(pack);
        return "redirect: /pack/profile";
    }

    @GetMapping("/pack/profile")
    public String showPackProfile(){
        return "pack/profile";
    }
}

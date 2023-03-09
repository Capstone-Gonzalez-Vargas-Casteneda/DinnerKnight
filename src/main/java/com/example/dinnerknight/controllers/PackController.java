package com.example.dinnerknight.controllers;

import com.example.dinnerknight.models.Pack;
import com.example.dinnerknight.models.User;
import com.example.dinnerknight.repositories.PackRepository;
import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/packs/create")
    public String ShowPackRegisterForm( Model model){
        model.addAttribute("pack", new Pack());
        return  "redirect: /packs/create";
    }

    @PostMapping("/packs/save")
    public String savePack(@ModelAttribute Pack pack){
        System.out.println(pack);
        return "redirect: /packs/profile";
    }

    @GetMapping("/packs/profile")
    public String showPackProfile(){
        return "pack/profile";
    }
}

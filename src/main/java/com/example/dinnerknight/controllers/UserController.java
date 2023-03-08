package com.example.dinnerknight.controllers;

import com.example.dinnerknight.models.Pack;
import com.example.dinnerknight.models.User;
import com.example.dinnerknight.repositories.PackRepository;
import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository userDao;

    private final PackRepository packDao;

    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao,PackRepository packDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.packDao = packDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        userDao.save(user);
        return "redirect:/login";
    }
    @GetMapping("/profile")
    public String showProfile(){
        return "users/profile";
    }

//    @GetMapping("/profile/{id}/edit")
//    public String editUserProfile(Model model @PathVariable long id) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Pack pack = packDao.findPackById(id);
//
//        return "users/edit";
//    }
//
//    @GetMapping("/ads/{id}/edit")
//    public String editAdForm(Model model, @PathVariable long id) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Ad ad = adDao.findAdById(id);
//        if (user.getId() == ad.getUser().getId()) {
//            model.addAttribute("ad", ad);
//            return "ads/create";
//        } else {
//            return "redirect:/ads";
//        }
//    }
}


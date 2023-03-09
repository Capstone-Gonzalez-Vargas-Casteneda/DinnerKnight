package com.example.dinnerknight.controllers;


import com.example.dinnerknight.models.User;
import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserRepository userDao;

    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
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
    public String showProfile(Model model) {
        model.addAttribute("user", userDao.findUserById(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
        return "users/userProfileView";
    }

//    @GetMapping("/profile/{id}/edit")
//    public String editUserProfile(Model model @PathVariable long id) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Pack pack = packDao.findPackById(id);
//        return "users/edit";
//    }
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


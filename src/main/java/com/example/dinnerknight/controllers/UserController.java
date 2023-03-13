package com.example.dinnerknight.controllers;


import com.example.dinnerknight.models.Event;
import com.example.dinnerknight.models.User;
import com.example.dinnerknight.repositories.EventRepository;
import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserRepository userDao;

    private final EventRepository eventDao;

    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao,EventRepository eventDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.eventDao = eventDao;
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

    @GetMapping("/profile/{id}/edit")
    public String updateUser (@PathVariable long id,Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User editedUser = userDao.getReferenceById(id);
        if(user.getId() == editedUser.getId()){
            model.addAttribute("user", userDao.getReferenceById(id));
            return "users/register";
        }
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        model.addAttribute("user", userDao.findUserById(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
        return "users/userProfileView";
    }


}


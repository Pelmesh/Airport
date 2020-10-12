package com.example.airport.controller;

import com.example.airport.domein.User;
import com.example.airport.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users",userRepo.findAll());
        return "usersList";
    }

    @GetMapping(value = "{id}")
    public String userInfo(@PathVariable Long id, Model model){
        model.addAttribute("user",userRepo.findAllById(id));
        return "userEdit";
    }

    @PostMapping(value = "{id}")
    public String userUpdate(
                             User user,
                             Model model){
        userRepo.save(user);
        model.addAttribute("messages","Сохранен");
        model.addAttribute("user",user);
        return "userEdit";
    }

    @PostMapping(value = "delete/{id}")
    public String userDelete(@PathVariable Long id, Model model){
        userRepo.deleteById(id);
        return "redirect:/admin/users";
    }
}
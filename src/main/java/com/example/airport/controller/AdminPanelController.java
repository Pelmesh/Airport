package com.example.airport.controller;

import com.example.airport.repos.AirportRepo;
import com.example.airport.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AirportRepo airportRepo;

    @GetMapping(value = "")
    public String airport(Model model){
        return "admin";
    }

}

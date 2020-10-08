package com.example.airport.controller;

import com.example.airport.domein.Airport;
import com.example.airport.domein.User;
import com.example.airport.repos.AirportRepo;
import com.example.airport.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/airports")
public class AirportController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AirportRepo airportRepo;


    @GetMapping(value = "")
    public String airportList(Model model){
        model.addAttribute("airports",airportRepo.findAll());
        return "airport";
    }

    @PostMapping(value = "")
    public String addAirport(Airport airport,
                             @AuthenticationPrincipal User author,
                             Model model){
        Airport airFromDb = airportRepo.findByIATA(airport.getIATA());

        if (airFromDb != null) {
            model.addAttribute("airports",airportRepo.findAll());
            model.addAttribute("messages", "Airport Exist!");
            return "airport";
        }

        airport.setAuthor(author);
        airportRepo.save(airport);
        model.addAttribute("airports",airportRepo.findAll());
        model.addAttribute("messages", "Airport "+airport.getIATA()+" save!");
        return "airport";
    }

    @GetMapping(value = "{id}")
    public String airportEdit(@PathVariable Long id, Model model){
        model.addAttribute("airport",airportRepo.findAllById(id));
        return "airportEdit";
    }

    @PostMapping(value = "{id}")
    public String addAirport(@AuthenticationPrincipal User user,
                             Airport airport,
                             Model model){
        airport.setAuthor(user);
        airportRepo.save(airport);
        model.addAttribute("airports",airportRepo.findAll());
        model.addAttribute("messages", "Airport "+airport.getIATA()+" save!");
        return "airportEdit";
    }

    @PostMapping(value = "delete/{id}")
    public String addAirport(@PathVariable Long id, Model model){
        airportRepo.deleteById(id);
        return "redirect:/admin/airport";
    }

}

package com.example.airport.controller;

import com.example.airport.domein.User;
import com.example.airport.repos.AirportRepo;
import com.example.airport.repos.FlightRepo;
import com.example.airport.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping(name = "/")
public class MainPageController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private AirportRepo airportRepo;


    @GetMapping
    public String getMain(@AuthenticationPrincipal User user, Model model) {
        if (user != null){
            model.addAttribute("user", userRepo.findAllById(user.getId()));
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        model.addAttribute("flights", flightRepo.findAllByDateStartAfter(localDateTime));
        model.addAttribute("airports", airportRepo.findAll());
        return "mainPage";
    }


    @PostMapping
    public String searchFlight(@RequestParam String strDateStart,
                               @RequestParam String strDateEnd,
                               @RequestParam(value = "airportStart", required = false) Long airportStart,
                               @RequestParam(value = "airportEnd", required = false) Long airportEnd,
                               Model model) {
        model.addAttribute("dateStart", strDateStart);
        model.addAttribute("dateEnd", strDateEnd);
        LocalDateTime localDateTime = LocalDateTime.now();
        model.addAttribute("airports", airportRepo.findAll());
        boolean b = (!strDateStart.equals("") & !strDateEnd.equals(""));
        if(b & (airportStart != null & airportEnd != null)){
            model.addAttribute("flights",
                    flightRepo.findAllByAirportStartIdAndAirportEndIdAndDateStartAfterAndDateEndBefore
                            (airportStart, airportEnd, LocalDateTime.parse(strDateStart), LocalDateTime.parse(strDateEnd)));
            return "mainPage";
        }
        if((strDateStart.equals("") & strDateEnd.equals("")) & (airportStart != null & airportEnd != null)){
            model.addAttribute("flights",
                    flightRepo.findAllByAirportStartIdAndAirportEndIdAndDateStartAfter(airportStart,airportEnd,localDateTime));
            return "mainPage";
        }
        if(b & (airportStart == null & airportEnd == null)){
            model.addAttribute("flights",
                    flightRepo.findAllByDateStartAfterAndDateEndBefore
                            (LocalDateTime.parse(strDateStart),LocalDateTime.parse(strDateEnd)));
            return "mainPage";
        }
        model.addAttribute("flights", flightRepo.findAllByDateStartAfter(localDateTime));
        model.addAttribute("messages", "Check input");
        return "mainPage";
    }

}

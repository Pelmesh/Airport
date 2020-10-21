package com.example.airport.controller;

import com.example.airport.domein.Flight;
import com.example.airport.domein.User;
import com.example.airport.repos.AirportRepo;
import com.example.airport.repos.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
@RequestMapping("/admin/flight")
public class FlightController {
    @Autowired
    private AirportRepo airportRepo;
    @Autowired
    private FlightRepo flightRepo;

    @GetMapping(value = "")
    public String getFlight(Model model) {
        model.addAttribute("airports", airportRepo.findAll());
        model.addAttribute("flights", flightRepo.findAll());
        return "flight";
    }

    @PostMapping(value = "")
    public String addFlight(@RequestParam String strDateStart,
                            @RequestParam String strDateEnd,
                            @AuthenticationPrincipal User author,
                            Flight flight,
                            Model model) {
        model.addAttribute("airports", airportRepo.findAll());
        model.addAttribute("flights", flightRepo.findAll());

        if(flight.getTotalNumberSeats() < 0){
            model.addAttribute("messages", "Check number seats!");
            return "flight";
        }
        if(flight.getAirportStart().equals(flight.getAirportEnd())){
            model.addAttribute("messages", "Check Airports!");
            return "flight";
        }

        flight.setAuthor(author);
        flight.setRemainingNumberSeats(flight.getTotalNumberSeats());
        flight.setDateStart(LocalDateTime.parse(strDateStart));
        flight.setDateEnd(LocalDateTime.parse(strDateEnd));
        if(flight.getDateStart().compareTo(flight.getDateEnd()) > 0 ||
                flight.getDateStart().compareTo(flight.getDateEnd()) == 0){
            model.addAttribute("messages", "Check Date!");
            return "flight";
        }

        Flight flightFromRepo = flightRepo.findAllByNumberFlight(flight.getNumberFlight());

        if (flightFromRepo != null) {
            model.addAttribute("messages", "Flight exists!");
            return "flight";
        }

        flight.setTimeFlight(getTime(flight.getDateStart(), flight.getDateEnd()));
        flightRepo.save(flight);
        return "flight";
    }

    private LocalTime getTime(LocalDateTime dateStart, LocalDateTime dateEnd) {
        Duration duration = Duration.between(dateEnd, dateStart);
        return LocalTime.MIN.minus(duration);
    }

}


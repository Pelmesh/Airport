package com.example.airport.controller;

import com.example.airport.domein.Airport;
import com.example.airport.domein.Flight;
import com.example.airport.domein.Ticket;
import com.example.airport.repos.FlightRepo;
import com.example.airport.repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "buy")
public class BuyTicketController {
    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping(value = "{id}")
    public String getTicket(@PathVariable Long id, Model model){
        Flight flight = flightRepo.findAllById(id);
        model.addAttribute("flight", flight);
        if(flight == null){
            model.addAttribute("messages", "404");
            return "buyTicket";
        }
        if(flight.getRemainingNumberSeats()==0) {
            model.addAttribute("messages", "All tickets are sold out");
            return "buyTicket";
        }
        return "buyTicket";
    }

    @PostMapping(value = "{id}")
    public String buyTicket(@PathVariable Long id, Ticket ticket, Model model,
                            @Autowired  Flight fl
                            ) {
        Flight flight = flightRepo.findAllById(id);
        if(flight.getRemainingNumberSeats() == 0){
            model.addAttribute("messages", "All tickets are sold out");
            return "buyTicket";
        }
        flight.setRemainingNumberSeats(flight.getRemainingNumberSeats()-1);
        flightRepo.save(flight);
        ticket.setFlight(flight);
        Ticket tkBuy  = ticketRepo.saveAndFlush(ticket);
        String txtMessage = "Ваш номер билета:"+tkBuy.getId();
        model.addAttribute("messageBuy", txtMessage);
        return "buyTicket";
    }

}

package com.example.airport.repos;

import com.example.airport.domein.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}

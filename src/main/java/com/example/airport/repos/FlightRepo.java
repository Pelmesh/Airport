package com.example.airport.repos;

import com.example.airport.domein.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight ,Long> {
    Flight findAllByNumberFlight(String numberFlight);
}

package com.example.airport.repos;


import com.example.airport.domein.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport,Long> {
    Airport findByIATA(String IATA);
    Airport findAllById(Long id);
}

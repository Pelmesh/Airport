package com.example.airport.repos;

import com.example.airport.domein.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepo extends JpaRepository<Flight ,Long> {
    Flight findAllByNumberFlight(String numberFlight);
    List<Flight> findAllByDateStartAfter(LocalDateTime date);
    List<Flight> findAllByAirportStartIdAndAirportEndIdAndDateStartAfter(Long airportStart, Long airportEnd, LocalDateTime dateStart);
    List<Flight> findAllByDateStartAfterAndDateEndBefore(LocalDateTime dateStart,LocalDateTime dateEnd);
    List<Flight> findAllByAirportStartIdAndAirportEndIdAndDateStartAfterAndDateEndBefore
            (Long airportStart, Long airportEnd, LocalDateTime dateStart, LocalDateTime dateEnd);
    //List<Flight> findAllByIdAndRemainingNumberSeatsAfter(Long id,int number);
    //Flight findAllByIdAndRemainingNumberSeatsAfter(Long id,int number);
    Flight findAllById(Long id);
}

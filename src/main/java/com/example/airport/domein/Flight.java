package com.example.airport.domein;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numberFlight;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private LocalTime timeFlight;
    private int totalNumberSeats;
    private int remainingNumberSeats;



    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idAirportStart")
    private Airport airportStart;



    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idAirportEnd")
    private Airport airportEnd;



    public Flight() {

    }

    public Airport getAirportStart() {
        return airportStart;
    }

    public void setAirportStart(Airport airportStart) {
        this.airportStart = airportStart;
    }

    public Airport getAirportEnd() {
        return airportEnd;
    }

    public void setAirportEnd(Airport airportEnd) {
        this.airportEnd = airportEnd;
    }


    public Flight(User user){
        this.author=user;
    }

    public int getTotalNumberSeats() {
        return totalNumberSeats;
    }

    public void setTotalNumberSeats(int totalNumberSeats) {
        this.totalNumberSeats = totalNumberSeats;
    }

    public int getRemainingNumberSeats() {
        return remainingNumberSeats;
    }

    public void setRemainingNumberSeats(int remainingNumberSeats) {
        this.remainingNumberSeats = remainingNumberSeats;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberFlight() {
        return numberFlight;
    }

    public void setNumberFlight(String numberFlight) {
        this.numberFlight = numberFlight;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public LocalTime getTimeFlight() {
        return timeFlight;
    }

    public void setTimeFlight(LocalTime timeFlight) {
        this.timeFlight = timeFlight;
    }


}

package ironhack.com.jpalab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor



public class Flight {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int bookingId;
    private String flightNumber;
    private String aircraft;
    private int totalAircraftSeats;
    private int flightMileage;

    public Flight() {

    }

    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage)  {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }


}

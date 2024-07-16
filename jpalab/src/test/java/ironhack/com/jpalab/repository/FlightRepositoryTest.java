package ironhack.com.jpalab.repository;

//import ironhack.com.jpalab.repositories.FlightRepository;
import ironhack.com.jpalab.model.Flight;
import ironhack.com.jpalab.repositories.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;




@DataJpaTest

public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    void setup() {

        //
        flightRepository.deleteAll();

        //Create new flight entity
        Flight flight = new Flight("7354", "Boeing 747", 200, 200);
        Flight flight1 = new Flight("4556", "Boeing 777", 300, 1400);
        Flight flight2 = new Flight("8479", "Airbus A330", 250, 1600);
        Flight flight3 = new Flight("9982", "Boeing 747", 200, 450);
        Flight flight4 = new Flight("6012", "Airbus A330", 250, 1120);

        //Save the newly created flight
        flightRepository.saveAll(List.of(flight, flight1, flight2, flight3, flight4));
    }


    @Test
    public void testCreateFlight() {

        Flight flight = flightRepository.findByFlightNumber("8479").orElseThrow(() -> new RuntimeException("Flight not found"));


        //Verify the flight was saved successfully
        assertNotNull(flight);

        //Retrieve the flight by ID
        Optional<Flight> retrievedFlight = flightRepository.findById(flight.getBookingId());

        //Verify the retrieved flight
        assertTrue(retrievedFlight.isPresent());
        assertEquals("8479", retrievedFlight.get().getFlightNumber());
        assertEquals("Airbus A330", retrievedFlight.get().getAircraft());
        assertEquals(250, retrievedFlight.get().getTotalAircraftSeats());
        assertEquals(1600, retrievedFlight.get().getFlightMileage());

    }

    @Test
    public void testFindByNameContaining() {

        List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");

        assertEquals(3, flights.size());
    }

    @Test
    public void testFindByFlightMileageGreaterThan() {

        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500);

        assertEquals(3, flights.size());
    }







}


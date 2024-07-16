package ironhack.com.jpalab.repositories;

import ironhack.com.jpalab.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    //Custom query for finding flight by flight number
    Optional<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByAircraftContaining(String name);

    List<Flight> findByFlightMileageGreaterThan(int mileage);




}

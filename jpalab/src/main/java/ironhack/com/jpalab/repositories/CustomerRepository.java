package ironhack.com.jpalab.repositories;

import ironhack.com.jpalab.model.Customer;
import ironhack.com.jpalab.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerName(String name);

    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);

}

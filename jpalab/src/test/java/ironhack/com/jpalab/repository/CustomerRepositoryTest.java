package ironhack.com.jpalab.repository;


import ironhack.com.jpalab.model.Customer;
import ironhack.com.jpalab.model.CustomerStatus;
import ironhack.com.jpalab.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static ironhack.com.jpalab.model.CustomerStatus.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setup() {

        customerRepository.deleteAll();

        //Create a new customer
        Customer customer = new Customer("Jane Bio", GOLD, 123);
        Customer customer1 = new Customer("Vlash Kipernik", NONE, 67);
        Customer customer2 = new Customer("Hala Zuom", SILVER, 105);
        Customer customer3 = new Customer("Sane Jill", GOLD, 189);
        Customer customer4 = new Customer("Trakt Pelonius", NONE, 150);

        customerRepository.saveAll(List.of(customer1,customer2,customer3, customer4, customer));

    }

    @Test
    public void testCreateCustomer() {


        //retrieve the customer by name
        Customer customer = customerRepository.findByCustomerName("Vlash Kipernik").orElseThrow(() -> new RuntimeException("No customer found with that name"));

        //Verify the customer was saved successfully
        assertNotNull(customer);

        //Retrieve the customer by ID
        Optional<Customer> retrievedCustomer = customerRepository.findById(customer.getCustomerId());

        //Verify the retrieved customer
        assertTrue(retrievedCustomer.isPresent());
        assertEquals("Vlash Kipernik", retrievedCustomer.get().getCustomerName());
        assertEquals(NONE, retrievedCustomer.get().getCustomerStatus());
        assertEquals(67, retrievedCustomer.get().getTotalCustomerMileage());


    }

    @Test
    public void testFindCustomerByStatus() {

        List<Customer> customers = customerRepository.findByCustomerStatus(NONE);

        assertEquals(2, customers.size());
    }


}

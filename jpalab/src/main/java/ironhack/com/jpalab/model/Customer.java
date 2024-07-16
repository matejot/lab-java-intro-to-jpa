package ironhack.com.jpalab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.NotFound;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor



public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int customerId;
    private String customerName;

    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    private int totalCustomerMileage;

    public Customer() {

    }

    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }


}

package haui.estate.business.repositories;

import haui.estate.business.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    boolean existsByCustomerNameAndStatus(String name, int status);
}

package foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import foodie.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);
}

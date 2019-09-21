package foodie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import foodie.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAllByCustomerEmail(String userEmail);

}

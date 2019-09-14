package foodie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import foodie.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	@Query(nativeQuery = true, value = "SELECT id, quantity, item_id, COUNT('item_id') AS 'counter' FROM order_item GROUP BY item_id ORDER BY 'counter' DESC LIMIT 9")
	List<OrderItem> findMostPopularItems();

}
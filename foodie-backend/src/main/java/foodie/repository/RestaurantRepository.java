package foodie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import foodie.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	@Query(value = "SELECT * from restaurant where category = :value ", nativeQuery = true)
	List<Restaurant> findAllByCategoryValue(@Param("value") int category);

}

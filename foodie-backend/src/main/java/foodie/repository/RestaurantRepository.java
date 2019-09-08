package foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import foodie.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}

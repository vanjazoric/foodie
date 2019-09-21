package foodie.service;

import java.util.List;

import foodie.model.Restaurant;

public interface RestaurantService {

	Restaurant findById(Long id);
	
	Restaurant create(Restaurant restaurant);

	Restaurant update(Restaurant restaurant);

	void delete(Long id);

	List<Restaurant> findAllByCategoryValue(int category);
}

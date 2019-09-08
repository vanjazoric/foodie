package foodie.service;

import foodie.model.Restaurant;

public interface RestaurantService {

	Restaurant create(Restaurant restaurant);

	Restaurant update(Restaurant restaurant);

	void delete(Long id);
}

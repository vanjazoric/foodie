package foodie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodie.exception.ResourceNotFoundException;
import foodie.model.Restaurant;
import foodie.repository.RestaurantRepository;
import foodie.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public Restaurant create(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant update(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Restaurant findById(Long id) {
		return restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant", "id", id));
	}

	@Override
	public List<Restaurant> findAllByCategoryValue(int category) {
		return restaurantRepository.findAllByCategoryValue(category);
	}
	
	
}

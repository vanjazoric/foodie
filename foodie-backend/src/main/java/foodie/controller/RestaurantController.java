package foodie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodie.model.Restaurant;
import foodie.service.RestaurantService;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	static final String UPLOAD_DIR = "D://uploads/Foodie";

	@GetMapping("{id}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
		return new ResponseEntity<Restaurant>(restaurantService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Restaurant>> getRestaurants(@PathVariable int category) {
		return new ResponseEntity<List<Restaurant>>(restaurantService.findAllByCategoryValue(category), HttpStatus.OK);
	}

	@GetMapping(value = "logo/{id}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable Long id) throws IOException {
		File file = new File(UPLOAD_DIR + File.separator + "restaurant-" + id + ".png");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
	}

}

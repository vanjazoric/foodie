package foodie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodie.dto.ItemResponse;
import foodie.service.ItemService;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/popular")
	public ResponseEntity<List<ItemResponse>> getMostPopularItems() {
		return new ResponseEntity<List<ItemResponse>>(itemService.getMostPopularItems(), HttpStatus.OK);
	}
}
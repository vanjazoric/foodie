package foodie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodie.dto.ItemResponse;
import foodie.model.Item;
import foodie.model.OrderItem;
import foodie.repository.ItemRepository;
import foodie.repository.OrderItemRepository;
import foodie.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public Item create(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<ItemResponse> getMostPopularItems() {
		List<OrderItem> orderItems = orderItemRepository.findMostPopularItems();
		List<Long> foundedItemIDs = orderItems.stream().map(element -> element.getItem().getId())
				.collect(Collectors.toList());
		List<Item> items = itemRepository.findAllWithSpecificIDs(foundedItemIDs);
		return itemsToItemsResponse(items);
	}

	@Override
	public java.util.List<ItemResponse> itemsToItemsResponse(java.util.List<Item> items) {
		List<ItemResponse> responseItems = new ArrayList<ItemResponse>();
		for (Item item : items) {
			ItemResponse itemResponse = new ItemResponse();
			itemResponse.setId(item.getId());
			itemResponse.setName(item.getName());
			itemResponse.setPrice(item.getPrice());
			itemResponse.setDescription(item.getDescription());
			itemResponse.setWeight(item.getWeight());
			itemResponse.setRestaurantId(item.getRestaurant().getId());
			itemResponse.setRestaurantName(item.getRestaurant().getName());
			responseItems.add(itemResponse);
		}
		return responseItems;
	}

}

package foodie.service;

import java.util.List;

import foodie.dto.ItemResponse;
import foodie.model.Item;

public interface ItemService {

	Item create(Item item);

	Item update(Item item);

	void delete(Long id);

	List<ItemResponse> getMostPopularItems();

	List<ItemResponse> itemsToItemsResponse(List<Item> items);
}

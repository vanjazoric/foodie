package foodie.service;

import foodie.model.Item;

public interface ItemService {

	Item create(Item item);

	Item update(Item item);

	void delete(Long id);
}

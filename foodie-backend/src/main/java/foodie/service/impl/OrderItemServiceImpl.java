package foodie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodie.dto.OrderItemDto;
import foodie.model.OrderItem;
import foodie.repository.ItemRepository;
import foodie.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<OrderItem> convertOrderItemsDtoToOrderItems(List<OrderItemDto> itemsDto) {
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (OrderItemDto dto : itemsDto) {
			OrderItem orderItem = new OrderItem();
			orderItem.setQuantity(dto.getQuantity());
			orderItem.setItem(itemRepository.findById(dto.getItemId()).get());
			orderItems.add(orderItem);
		}
		return orderItems;
	}

	@Override
	public List<OrderItemDto> convertOrderItemsToOrderItemsDto(List<OrderItem> items) {
		ArrayList<OrderItemDto> orderItems = new ArrayList<OrderItemDto>();
		for (OrderItem item : items) {
			OrderItemDto dto = new OrderItemDto();
			dto.setQuantity(item.getQuantity());
			dto.setRestaurantName(item.getItem().getRestaurant().getName());
			dto.setItemName(item.getItem().getName());
			orderItems.add(dto);
		}
		return orderItems;
	}
}

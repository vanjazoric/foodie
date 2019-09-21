package foodie.service;

import java.util.List;

import foodie.dto.OrderItemDto;
import foodie.model.OrderItem;

public interface OrderItemService {

	List<OrderItem> convertOrderItemsDtoToOrderItems(List<OrderItemDto> itemsDto);
	
	List<OrderItemDto> convertOrderItemsToOrderItemsDto(List<OrderItem> items);
}

package foodie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {

	private Long itemId;

	private String itemName;

	private int quantity;

	private double price;

	private Long restaurantId;

	private String restaurantName;

}

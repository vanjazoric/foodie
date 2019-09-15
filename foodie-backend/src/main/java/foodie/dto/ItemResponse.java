package foodie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponse {
	
	private Long id;

	private String name;

	private double price;
	
	private String description;

	private String weight;

	private String restaurantName;

	private Long restaurantId;

}

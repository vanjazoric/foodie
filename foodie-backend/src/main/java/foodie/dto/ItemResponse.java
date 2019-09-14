package foodie.dto;

import foodie.model.ItemType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponse {

	private String name;

	private double price;

	private ItemType type;

}

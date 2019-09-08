package foodie.model;

import lombok.Getter;

@Getter
public enum ItemType {

	FOOD(0), DRINK(1);

	private int value;

	ItemType(int value) {
		this.value = value;
	}
}

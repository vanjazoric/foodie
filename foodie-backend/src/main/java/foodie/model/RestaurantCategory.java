package foodie.model;

import lombok.Getter;

@Getter
public enum RestaurantCategory {

	NATIONAL_CUISINE(0), FAST_FOOD(1), CHINESE_CUISINE(2), ITALIAN_CUISINE(3), SWEETS(4), VEGETARIAN(5);

	private int value;

	RestaurantCategory(int value) {
		this.value = value;
	}
}

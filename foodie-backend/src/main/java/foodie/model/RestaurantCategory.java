package foodie.model;

import lombok.Getter;

@Getter
public enum RestaurantCategory {

	NATIONAL_CUISINE(0), FAST_FOOD(1), CHINESE_CUISINE(2), GREEK_CUISINE(3), ITALIAN_CUISINE(4), SWEETS(5), PIZZERIA(6);

	private int value;

	RestaurantCategory(int value) {
		this.value = value;
	}
}

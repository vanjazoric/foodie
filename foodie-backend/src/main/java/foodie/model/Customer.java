package foodie.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends User {

	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	@OneToMany
	private List<Restaurant> favoriteRestaurants;
}

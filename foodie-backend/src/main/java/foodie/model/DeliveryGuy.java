package foodie.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DeliveryGuy extends User {

	@OneToOne
	private Vehicle vehicle;

	@OneToMany(mappedBy = "deliveryGuy", cascade = CascadeType.ALL)
	private List<Order> orders;
}

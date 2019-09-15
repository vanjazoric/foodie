package foodie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private double price;

	private String description;

	private ItemType type;

	private String imageUrl;

	// grams for food, mililiters for drinks
	private String weight;

	@Column(columnDefinition = "BOOLEAN")
	private boolean deleted;

	@ManyToOne
	private Restaurant restaurant;
}

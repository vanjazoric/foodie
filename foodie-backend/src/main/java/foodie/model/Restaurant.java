package foodie.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String address;

	private String logo;

	private RestaurantCategory category;

	@JsonIgnoreProperties("restaurant")
	@OneToMany
	private List<Item> foodItems;

	@JsonIgnoreProperties("restaurant")
	@OneToMany
	private List<Item> drinks;

	@JsonBackReference
	@Column(columnDefinition = "BOOLEAN")
	private boolean deleted;

}

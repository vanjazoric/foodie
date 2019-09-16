package oauth2.resourceserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String email;

	private String firstName;

	private String lastName;

	private String address;
	
	private String phoneNumber;

	private String imageUrl;

	public User(Long id, String username, String email, String firstName, String lastName, String phoneNumber,
			String imageUrl) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.imageUrl = imageUrl;
	}
}

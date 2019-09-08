package foodie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

	private String username;

	private String email;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String image;
	
	private String role;

}

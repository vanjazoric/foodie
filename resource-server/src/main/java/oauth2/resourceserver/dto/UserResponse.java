package oauth2.resourceserver.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {
	
	private String username;
	
	private String email;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String imageUrl;
	
	private String address;

}

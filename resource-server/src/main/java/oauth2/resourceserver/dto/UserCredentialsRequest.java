package oauth2.resourceserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserCredentialsRequest {

	private String username;

	private String password;
	
	private String email;
}

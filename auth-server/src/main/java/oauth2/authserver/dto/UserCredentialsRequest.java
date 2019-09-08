package oauth2.authserver.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCredentialsRequest {

	private String username;

	private String password;
	
	private String email;
}

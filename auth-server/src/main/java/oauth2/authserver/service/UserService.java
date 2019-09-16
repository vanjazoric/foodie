package oauth2.authserver.service;

import oauth2.authserver.dto.UserCredentialsRequest;
import oauth2.authserver.entity.User;

public interface UserService {
	
	boolean saveUser(UserCredentialsRequest credentials);

	boolean existUser(String username, String email);
	
	User findByUsername(String username);

}

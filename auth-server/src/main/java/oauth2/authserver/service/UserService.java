package oauth2.authserver.service;

import oauth2.authserver.dto.UserCredentialsRequest;

public interface UserService {

	boolean checkAndSaveUser(UserCredentialsRequest credentials);

}

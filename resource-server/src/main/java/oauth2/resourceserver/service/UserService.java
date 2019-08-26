package oauth2.resourceserver.service;

import oauth2.resourceserver.dto.UserResponse;
import oauth2.resourceserver.model.User;

public interface UserService {
	
	UserResponse findByUsername(String username);
	
	UserResponse convertToUserResponse(User user);

}

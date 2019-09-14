package oauth2.resourceserver.service;

import javax.servlet.http.HttpServletRequest;

import oauth2.resourceserver.dto.SignUpRequest;
import oauth2.resourceserver.dto.UserResponse;
import oauth2.resourceserver.model.User;

public interface UserService {
	
	UserResponse findByUsername(String username);
	
	boolean findByEmail(String email);	
	
	UserResponse convertToUserResponse(User user);

	UserResponse create(SignUpRequest request);
	
}

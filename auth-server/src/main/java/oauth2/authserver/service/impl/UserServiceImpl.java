package oauth2.authserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oauth2.authserver.dto.UserCredentialsRequest;
import oauth2.authserver.entity.User;
import oauth2.authserver.repository.UserRepository;
import oauth2.authserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public boolean checkAndSaveUser(UserCredentialsRequest credentials) {
		User user = userRepository.findByUsername(credentials.getUsername());
		if (user == null) {
			User newUser = new User();
			newUser.setUsername(credentials.getUsername());
			newUser.setPassword(credentials.getPassword());
			newUser.setEmail(credentials.getEmail());
			userRepository.save(newUser);
			return false;
			// If user already exists and registration with that username and email is not allowed
		} else {
			return true;
		}
	}

}

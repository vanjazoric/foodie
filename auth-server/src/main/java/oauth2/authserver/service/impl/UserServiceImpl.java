package oauth2.authserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oauth2.authserver.dto.UserCredentialsRequest;
import oauth2.authserver.entity.Role;
import oauth2.authserver.entity.User;
import oauth2.authserver.repository.RoleRepository;
import oauth2.authserver.repository.UserRepository;
import oauth2.authserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public boolean existUser(String username, String email) {
		User user = userRepository.findByUsernameOrEmail(username, email);
		if (user == null) {
			return false;
			// If user already exists and registration with that username and email is not
			// allowed
		} else {
			return true;
		}
	}

	@Override
	public boolean saveUser(UserCredentialsRequest credentials) {
		User newUser = new User();
		newUser.setUsername(credentials.getUsername());
		newUser.setPassword(credentials.getPassword());
		newUser.setEmail(credentials.getEmail());
		Role role = roleRepository.findByName("ROLE_USER");
		newUser.setRole(role);
		newUser.setRole(role);
		userRepository.save(newUser);
		return true;
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}

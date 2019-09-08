package oauth2.resourceserver.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import exception.UserAlreadyExistsException;
import oauth2.resourceserver.dto.SignUpRequest;
import oauth2.resourceserver.dto.UserCredentialsRequest;
import oauth2.resourceserver.dto.UserResponse;
import oauth2.resourceserver.model.User;
import oauth2.resourceserver.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponse findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return convertToUserResponse(user);
	}

	@Override
	public UserResponse convertToUserResponse(User user) {
		UserResponse userResponse = modelMapper.map(user, UserResponse.class);
		return userResponse;
	}

	@Override
	public boolean findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if (user != null)
			return true;
		else
			return false;
	}

	@Transactional
	@Override
	public UserResponse create(SignUpRequest request) throws UserAlreadyExistsException {
		UserCredentialsRequest credentials = new UserCredentialsRequest(request.getUsername(), request.getPassword(),
				request.getEmail());
		if (emailExists(credentials)) {
			throw new UserAlreadyExistsException("There is an account with that email address:" + request.getEmail());
		}
		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPhone(request.getPhoneNumber());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		return convertToUserResponse(userRepository.save(user));
	}

	private boolean emailExists(UserCredentialsRequest credentials) {
		Boolean existsOnAuth = restTemplate.postForObject("http://localhost:9999/users/check-credentials", credentials,
				Boolean.class);
		User user = userRepository.findByEmail(credentials.getEmail());
		if (user != null || existsOnAuth) {
			return true;
		}
		return false;
	}

}

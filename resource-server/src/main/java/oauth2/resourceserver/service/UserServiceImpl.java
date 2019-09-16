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

	static final String BASE_URL = "http://localhost:9000/images/";

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ImageService imageService;

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
		UserCredentialsRequest credentials = new UserCredentialsRequest(request.getUsername(),
				passwordEncoder.encode(request.getPassword()), request.getEmail());
		if (userExists(credentials.getUsername(), credentials.getEmail())) {
			throw new UserAlreadyExistsException("There is an account with that email address:" + request.getEmail());
		}
		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setAddress(request.getAddress());
		user.setEmail(request.getEmail());
		if (imageService.uploadImage(request.getImage(), request.getUsername())) {
			user.setImageUrl(BASE_URL + "username");
		}
		// Save user on the Authorization server
		saveUserOnAuth(credentials);
		return convertToUserResponse(userRepository.save(user));
	}

	private boolean userExists(String username, String email) {
		Boolean existsOnAuth = restTemplate.getForObject(
				"http://localhost:9999/auth/users/check-user?username=" + username + "&email=" + email, Boolean.class);
		User user = userRepository.findByEmail(email);
		if (user != null || existsOnAuth) {
			return true;
		}
		return false;
	}

	private boolean saveUserOnAuth(UserCredentialsRequest credentials) {
		Boolean saveOnAuth = restTemplate.postForObject("http://localhost:9999/auth/users/save-user", credentials,
				Boolean.class);
		if (saveOnAuth) {
			return true;
		}
		return false;
	}
}

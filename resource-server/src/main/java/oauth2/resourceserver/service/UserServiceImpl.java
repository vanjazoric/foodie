package oauth2.resourceserver.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oauth2.resourceserver.dto.UserResponse;
import oauth2.resourceserver.model.User;
import oauth2.resourceserver.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	ModelMapper modelMapper;

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

}

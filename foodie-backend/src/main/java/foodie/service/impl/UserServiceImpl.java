package foodie.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodie.dto.UserResponse;
import foodie.exception.ResourceNotFoundException;
import foodie.model.User;
import foodie.repository.UserRepository;
import foodie.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}

	@Override
	public UserResponse getCurrentUser(Long id) {
		User user = findById(id);
		UserResponse userResponse = modelMapper.map(user, UserResponse.class);
		userResponse.setRole(user.getRole().getName());
		return userResponse;
	}
}
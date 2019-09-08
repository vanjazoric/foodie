package foodie.service;

import foodie.dto.UserResponse;
import foodie.model.User;

public interface UserService {

	User findById(Long id);

	UserResponse getCurrentUser(Long id);
}

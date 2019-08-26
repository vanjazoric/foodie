package foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import foodie.domain.User;
import foodie.exception.ResourceNotFoundException;
import foodie.repository.UserRepository;
import foodie.security.CurrentUser;
import foodie.security.UserPrincipal;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("auth/user/me")
	// @PreAuthorize("hasRole('USER')")
	public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		return userRepository.findById(userPrincipal.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
	}
}
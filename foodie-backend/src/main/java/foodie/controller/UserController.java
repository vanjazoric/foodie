package foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodie.dto.UserResponse;
import foodie.security.CurrentUser;
import foodie.security.UserPrincipal;
import foodie.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/me")
	public ResponseEntity<UserResponse> getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		UserResponse userResponse = userService.getCurrentUser(userPrincipal.getId());
		System.out.println("AAA" +userResponse);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
}
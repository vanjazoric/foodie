package oauth2.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oauth2.authserver.dto.UserCredentialsRequest;
import oauth2.authserver.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/check-user")
	public boolean checkCredentials(@RequestParam String username, @RequestParam String email) {
		return userService.existUser(username, email);
	}

	@PostMapping("/save-user")
	public boolean saveUser(@RequestBody UserCredentialsRequest credentials) {
		return userService.saveUser(credentials);
	}
}

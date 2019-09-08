package oauth2.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oauth2.authserver.dto.UserCredentialsRequest;
import oauth2.authserver.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/check-credentials")
	public boolean checkCredentials(@RequestBody UserCredentialsRequest credentials) {
		return userService.checkAndSaveUser(credentials);
	}

}

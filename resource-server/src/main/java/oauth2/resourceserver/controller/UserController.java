package oauth2.resourceserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import oauth2.resourceserver.dto.UserResponse;
import oauth2.resourceserver.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/user")
	@ResponseBody
	public UserResponse user(Principal principal) {
		UserResponse user = userService.findByUsername(principal.getName());
		return user;
	}
}

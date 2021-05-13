package foodie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Value("${uploadDir}")
	private String UPLOAD_DIR;

	@GetMapping("/me")
	public ResponseEntity<UserResponse> getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		UserResponse userResponse = userService.getCurrentUser(userPrincipal.getId());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}

	@GetMapping(value = "image/{id}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable Long id) throws IOException {
		File file = new File(UPLOAD_DIR + File.separator + "user-" + id + ".png");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
	}
}
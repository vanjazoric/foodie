package oauth2.resourceserver.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class ImageController {

	@GetMapping(value = "{username}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable String username) throws IOException {
		ClassPathResource imgFile = new ClassPathResource("img/" + username + ".png");
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
				.body(new InputStreamResource(imgFile.getInputStream()));
	}
}

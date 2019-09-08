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
@RequestMapping("/image")
public class ImageController {

	@GetMapping(value = "{userId}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable Long userId) throws IOException {
		ClassPathResource imgFile = new ClassPathResource("image/" + userId + ".png");
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
				.body(new InputStreamResource(imgFile.getInputStream()));
	}
}

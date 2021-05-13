package oauth2.resourceserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {

	@Value("${uploadDir}")
	private String UPLOAD_DIR;

	@GetMapping(value = "{username}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable String username) throws IOException {
		File file = new File(UPLOAD_DIR + File.separator + "user-" + username + ".png");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
	}
}

package foodie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodie.dto.ItemResponse;
import foodie.service.ItemService;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Value("${uploadDir}")
	private String UPLOAD_DIR;

	@GetMapping("/popular")
	public ResponseEntity<List<ItemResponse>> getMostPopularItems() {
		return new ResponseEntity<List<ItemResponse>>(itemService.getMostPopularItems(), HttpStatus.OK);
	}

	@GetMapping(value = "image/{id}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable Long id) throws IOException {
		File file = new File(UPLOAD_DIR + File.separator + "item-" + id + ".png");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
	}
}
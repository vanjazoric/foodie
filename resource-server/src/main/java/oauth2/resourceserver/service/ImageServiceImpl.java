package oauth2.resourceserver.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

	static final String UPLOAD_DIR = "D://uploads/MyService";

	@Override
	public boolean uploadImage(MultipartFile image, String username) {
		File file = new File(UPLOAD_DIR + File.separator + "user-" + username + ".png");
		if (!image.isEmpty()) {
			try {
				image.transferTo(file);
				return true;
			} catch (IllegalStateException | IOException e) {
				return false;
			}
		}
		return false;
	}
}

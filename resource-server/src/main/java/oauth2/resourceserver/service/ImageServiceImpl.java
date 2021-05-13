package oauth2.resourceserver.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

	@Value("${uploadDir}")
	private String UPLOAD_DIR;

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

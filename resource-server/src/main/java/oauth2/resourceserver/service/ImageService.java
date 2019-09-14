package oauth2.resourceserver.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	boolean uploadImage(MultipartFile image, String string);
}

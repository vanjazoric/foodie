package oauth2.resourceserver.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import oauth2.resourceserver.validation.PasswordMatches;
import oauth2.resourceserver.validation.ValidEmail;

@Getter
@Setter
@PasswordMatches
public class SignUpRequest {

	@NotBlank(message = "{validation.firstName.notEmpty}")
	private String firstName;

	@NotBlank(message = "{validation.username.notEmpty}")
	private String username;

	@NotBlank(message = "{validation.lastName.notEmpty}")
	private String lastName;

	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;

	@NotBlank(message = "{validation.password.notEmpty}")
	private String password;

	private String matchingPassword;

	@NotBlank(message = "{validation.phoneNumber.notEmpty}")
	private String phoneNumber;

	private MultipartFile image;

}
package oauth2.resourceserver.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import oauth2.resourceserver.validation.PasswordMatches;
import oauth2.resourceserver.validation.ValidEmail;

@Getter
@Setter
@PasswordMatches
public class SignUpRequest {

	@NotBlank
	private String firstName;

	@NotBlank
	private String username;

	@NotBlank
	private String lastName;

	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;

	@NotBlank
	private String password;

	private String matchingPassword;

	@NotBlank
	private String phoneNumber;

}
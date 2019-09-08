package oauth2.resourceserver.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import oauth2.resourceserver.dto.SignUpRequest;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		SignUpRequest request = (SignUpRequest) obj;
		return request.getPassword().equals(request.getMatchingPassword());
	}
}
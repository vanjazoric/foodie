package exception;

public final class UserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 5861310537366287163L;

	public UserAlreadyExistsException() {
		super();
	}

	public UserAlreadyExistsException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyExistsException(final String message) {
		super(message);
	}

	public UserAlreadyExistsException(final Throwable cause) {
		super(cause);
	}

}
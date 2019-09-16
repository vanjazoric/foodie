package oauth2.authserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientInfoResponse {

	private String clientId;

	private String clientSecret;

	private String clientName;

}

package oauth2.authserver.service;

import oauth2.authserver.dto.ClientCredentials;
import oauth2.authserver.entity.CustomClientDetails;

public interface ClientDetailsHelperService {

	ClientCredentials create(CustomClientDetails client);

	String generateClientId();
}

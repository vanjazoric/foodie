package oauth2.authserver.service;

import java.util.List;

import oauth2.authserver.dto.ClientCredentials;
import oauth2.authserver.dto.ClientInfoResponse;
import oauth2.authserver.entity.CustomClientDetails;

public interface ClientDetailsHelperService {

	ClientCredentials create(CustomClientDetails client);
	
	List<ClientInfoResponse> findAllByUser(String username);

	String generateRandomHex();
}

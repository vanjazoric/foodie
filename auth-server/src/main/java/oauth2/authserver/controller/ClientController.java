package oauth2.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import oauth2.authserver.dto.ClientCredentials;
import oauth2.authserver.entity.CustomClientDetails;
import oauth2.authserver.entity.User;
import oauth2.authserver.service.CustomClientDetailsService;

@Controller
@SessionAttributes("authorizationRequest")
public class ClientController {

	@Autowired
	private CustomClientDetailsService clientService;

	@Autowired
	private PasswordEncoder passwordEncoder;	

	@RequestMapping(value = "/create-client", method = RequestMethod.POST)
	public ResponseEntity<ClientCredentials> registerClient(@RequestParam("redirect-uri") String redirectUri,
			@RequestParam("client-name") String clientName, @AuthenticationPrincipal User user) {
		CustomClientDetails client = new CustomClientDetails();
		client.setClientId(clientService.generateClientId());
		client.setClientSecret(passwordEncoder.encode(clientService.generateClientId()));
		client.setUser(user);
		ClientCredentials credentials = clientService.create(client);
		return new ResponseEntity<ClientCredentials>(credentials, HttpStatus.CREATED);
	}
}

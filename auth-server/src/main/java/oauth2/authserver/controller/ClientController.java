package oauth2.authserver.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import oauth2.authserver.dto.ClientCredentials;
import oauth2.authserver.dto.ClientInfoResponse;
import oauth2.authserver.entity.CustomClientDetails;
import oauth2.authserver.service.CustomClientDetailsService;
import oauth2.authserver.service.UserService;

@Controller
@SessionAttributes("authorizationRequest")
public class ClientController {

	@Autowired
	private CustomClientDetailsService clientService;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/create-client", method = RequestMethod.POST)
	public ResponseEntity<ClientCredentials> registerClient(@RequestParam("redirect-uri") String redirectUri,
			@RequestParam("client-name") String clientName, Principal user) {
		CustomClientDetails client = new CustomClientDetails();
		client.setClientId(clientService.generateRandomHex());
		String generatedClientSecret = clientService.generateRandomHex();
		client.setClientSecret(passwordEncoder.encode(generatedClientSecret));
		client.setUser(userService.findByUsername(user.getName()));
		client.setClientName(clientName);
		client.setRedirectUri(redirectUri);
		client.setAccessTokenValidity(3600);
		client.setRefreshTokenValidity(3600);
		ClientCredentials credentials = clientService.create(client);
		credentials.setClientSecret(generatedClientSecret);
		return new ResponseEntity<ClientCredentials>(credentials, HttpStatus.CREATED);
	}

	@GetMapping("credentials")
	public ModelAndView getCredentials(Principal principal) {
		List<ClientInfoResponse> clientsInfo  = clientService.findAllByUser(principal.getName());
		ModelAndView model = new ModelAndView();
		model.setViewName("credentials");
		model.addObject("clients", clientsInfo);
		return model;
	}

}

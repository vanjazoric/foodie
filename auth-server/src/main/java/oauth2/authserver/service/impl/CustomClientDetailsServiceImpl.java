package oauth2.authserver.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Service;

import oauth2.authserver.dto.ClientCredentials;
import oauth2.authserver.dto.ClientInfoResponse;
import oauth2.authserver.entity.CustomClientDetails;
import oauth2.authserver.repository.ClientDetailsRepository;
import oauth2.authserver.service.CustomClientDetailsService;

@Service
public class CustomClientDetailsServiceImpl implements CustomClientDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private ClientDetailsRepository clientRepository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) {
		return clientRepository.findByClientId(clientId);
	}

	@Override
	public ClientCredentials create(CustomClientDetails client) {
		CustomClientDetails details = clientRepository.save(client);
		return convertToDto(details);
	}

	@Override
	public String generateClientId() {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		while (sb.length() < 32) {
			sb.append(Integer.toHexString(r.nextInt()));
		}
		String hex = sb.toString().substring(0, 32);
		return hex;
	}

	private ClientCredentials convertToDto(CustomClientDetails details) {
		ClientCredentials credentials = new ClientCredentials();
		credentials.setClientId(details.getClientId());
		credentials.setClientSecret(details.getClientSecret());
		credentials.setClientSecretExpiresAt(0);
		return credentials;

	}

	@Override
	public List<ClientInfoResponse> findAllByUser(String username) {
		List<CustomClientDetails> clientDetails = clientRepository.findByUserUsername(username);
		java.lang.reflect.Type listType = new TypeToken<List<ClientInfoResponse>>() {
		}.getType();
		return modelMapper.map(clientDetails, listType);
	}
}

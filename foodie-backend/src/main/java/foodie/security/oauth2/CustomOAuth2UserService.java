package foodie.security.oauth2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import foodie.exception.OAuth2AuthenticationProcessingException;
import foodie.model.AuthProvider;
import foodie.model.Customer;
import foodie.model.Role;
import foodie.model.User;
import foodie.repository.CustomerRepository;
import foodie.repository.RoleRepository;
import foodie.repository.UserRepository;
import foodie.security.UserPrincipal;
import foodie.security.oauth2.user.OAuth2UserInfo;
import foodie.security.oauth2.user.OAuth2UserInfoFactory;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

		try {
			return processOAuth2User(oAuth2UserRequest, oAuth2User);
		} catch (AuthenticationException ex) {
			throw ex;
		} catch (Exception ex) {
			// Throwing an instance of AuthenticationException will trigger the
			// OAuth2AuthenticationFailureHandler
			throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
		}
	}

	private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
		OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(
				oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
		if (StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
			throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
		}

		Optional<User> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
		User user;
		if (userOptional.isPresent()) {
			user = userOptional.get();
			user = updateExistingUser(oAuth2UserRequest, user, oAuth2UserInfo);
		} else {
			user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
		}

		return UserPrincipal.create(user, oAuth2User.getAttributes());
	}

	private User registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
		Customer user = new Customer();
		user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
		user.setProviderId(oAuth2UserInfo.getId());
		user.setFirstName(oAuth2UserInfo.getFirstName());
		user.setLastName(oAuth2UserInfo.getLastName());
		user.setEmail(oAuth2UserInfo.getEmail());
		user.setImageUrl(oAuth2UserInfo.getImageUrl());
		user.setPhoneNumber(oAuth2UserInfo.getPhoneNumber());
		user.setAddress(oAuth2UserInfo.getAddress());
		Role role = roleRepository.findByName("ROLE_CUSTOMER");
		user.setRole(role);

		return userRepository.save(user);
	}

	private User updateExistingUser(OAuth2UserRequest oAuth2UserRequest, User user, OAuth2UserInfo oAuth2UserInfo) {
		user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
		user.setProviderId(oAuth2UserInfo.getId());
		user.setFirstName(oAuth2UserInfo.getFirstName());
		user.setLastName(oAuth2UserInfo.getLastName());
		user.setEmail(oAuth2UserInfo.getEmail());
		user.setImageUrl(oAuth2UserInfo.getImageUrl());
		user.setPhoneNumber(oAuth2UserInfo.getPhoneNumber());
		user.setAddress(oAuth2UserInfo.getAddress());
		return userRepository.save(user);
	}

}
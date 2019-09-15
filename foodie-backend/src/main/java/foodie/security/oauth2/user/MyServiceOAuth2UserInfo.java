package foodie.security.oauth2.user;

import java.util.Map;

public class MyServiceOAuth2UserInfo extends OAuth2UserInfo {
	public MyServiceOAuth2UserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return (String) attributes.get("id");
	}

	@Override
	public String getFirstName() {
		return (String) attributes.get("firstName");
	}

	@Override
	public String getLastName() {
		return (String) attributes.get("lastName");
	}

	@Override
	public String getEmail() {
		return (String) attributes.get("email");
	}

	@Override
	public String getPhoneNumber() {
		return (String) attributes.get("phoneNumber");
	}
	
	@Override
	public String getImageUrl() {
		//if (attributes.containsKey("imageUrl")) {
			return (String) attributes.get("imageUrl");
	//	}
	//	return null;
	}
}

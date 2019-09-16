package oauth2.authserver.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "oauth_client_details")
public class CustomClientDetails implements ClientDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "client_secret")
	private String clientSecret;

	@Column
	private String scope;

	@Column(name = "authorized_grant_types")
	private String authorizedGrantTypes;

	@Column(name = "web_server_redirect_uri")
	private String redirectUri;

	@Column
	private String authorities;

	@Column(name = "access_token_validity")
	private int accessTokenValidity;

	@Column(name = "refresh_token_validity")
	private int refreshTokenValidity;

	@Column(name = "additional_information")
	private String additionalInformation;

	@Column(name = "autoapprove")
	private boolean autoApprove;

	@Column(name = "resource_ids")
	private String resourceIds;

	@ManyToOne
	private User user;

	private String clientName;

	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public Set<String> getResourceIds() {
		return resourceIds != null ? new HashSet<>(Arrays.asList(resourceIds.split(","))) : null;
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	@Override
	public boolean isScoped() {
		return false;
	}

	@Override
	public Set<String> getScope() {
		return scope != null ? new HashSet<>(Arrays.asList(scope.split(","))) : null;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes != null ? new HashSet<>(Arrays.asList(authorizedGrantTypes.split(","))) : null;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return redirectUri != null ? new HashSet<>(Arrays.asList(redirectUri.split(","))) : null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValidity;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValidity;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return true;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

}

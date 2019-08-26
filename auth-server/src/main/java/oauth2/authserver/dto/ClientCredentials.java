package oauth2.authserver.dto;

public class ClientCredentials {

	private String clientId;
	private String clientSecret;
	private long clientSecretExpiresAt;

	public ClientCredentials() {
		super();
	}

	public ClientCredentials(String clientId, String clientSecret, long clientSecretExpiresAt) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.clientSecretExpiresAt = clientSecretExpiresAt;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public long getClientSecretExpiresAt() {
		return clientSecretExpiresAt;
	}

	public void setClientSecretExpiresAt(long clientSecretExpiresAt) {
		this.clientSecretExpiresAt = clientSecretExpiresAt;
	}
}

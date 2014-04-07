import java.net.URI;

public class User {
	private String login;
	
	private URI avatarUri;
	
	public User(String login) {
		this.login = login;
	}

	public URI getAvatarUri() {
		return avatarUri;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setAvatarUri(URI avatarUri) {
		this.avatarUri = avatarUri;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
}

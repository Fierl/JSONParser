package model;

/** * The User class serves as the model of the user
 * 
 * inherits from AbstractEntity class*/
public class User extends AbstractEntity{
	
	private String key;
	private AvatarUrl avatarUrl; 
	private String displayName;
	private boolean active;
	
	public User(String self, String name, String key, AvatarUrl avatarUrl, String displayName, boolean active) {
		super(self, name);
		this.key = key;
		this.displayName = displayName;
		this.avatarUrl  = avatarUrl;
		this.active = active;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public AvatarUrl getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(AvatarUrl avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}

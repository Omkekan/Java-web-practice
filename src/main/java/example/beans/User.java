package example.beans;

public class User {
	
	private String userId;
	private String userPasssword;
	
	public User() {
		
	}
	
	
	public User(String userId, String userPasssword) {
		super();
		this.userId = userId;
		this.userPasssword = userPasssword;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getUserPasssword() {
		return userPasssword;
	}
	public void setUserPasssword(String userPasssword) {
		this.userPasssword = userPasssword;
	}
	
	

}

package example.beans;

public class UserValidator {
	public static boolean isValid(User appUser) {
		boolean valid = false;
		
		String currentUserId = appUser.getUserId();
		String currentPwd = appUser.getUserPasssword();
		
		if("admin".equals(currentUserId)&&"asAdmin".equals(currentPwd))
			valid = true;
		return valid;
	}
}

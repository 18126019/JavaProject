package src.application.java;


public class UserSession {
	private static UserSession instance;

	private String userName;

	private UserSession(String userName) {
		this.userName = userName;
	}

	public static UserSession getInstance(String userName) {
		if (instance == null) {
			instance = new UserSession(userName);
		}
		return instance;
	}

	public String getUserName() {
		return userName;
	}


	public void cleanUserSession() {
		userName = "";// or null
	}

	@Override
	public String toString() {
		return "UserSession{" +
				"userName='" + userName + '}';
	}
}


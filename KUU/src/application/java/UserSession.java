package src.application.java;


public class UserSession {
	private static UserSession instance;

	private String userName;
	private int id;

	private UserSession(String userName, int id) {
		this.userName = userName;
		this.id = id;
	}

	public static UserSession getInstace(String userName, int id) {
		if (instance == null) {
			instance = new UserSession(userName, id);
		}
		return instance;
	}

	public String getUserName() {
		return userName;
	}
	public int getId() {return id;}

	public void cleanUserSession() {
		userName = "";// or null
	}

	@Override
	public String toString() {
		return "UserSession{" +
				"userName='" + userName + '}';
	}
}


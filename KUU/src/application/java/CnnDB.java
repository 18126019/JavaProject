package src.application.java;
import java.sql.*;
public class CnnDB {
	private static final String DB_URL = "jdbc:sqlserver://localhost;databaseName=KUU;integratedSecurity=true";
	// Database credentials
	private static final String USER = "";
	private static final String PASS = "";
	private static final Connection cnn = getConnection(DB_URL, USER, PASS);
	
	public static Connection getConnection(String dbURL, String userName, String password) {
		Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
	}
	
	public Connection getDB() {
		return CnnDB.cnn;
	}
}

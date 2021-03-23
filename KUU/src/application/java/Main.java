package application.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import heSo.*;
import heSo.hesoDat.*;
import heSo.hesoNha.*;
import nguoiDung.*;
import nha.*;


//public class Main extends Application {
//	@Override
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/home.fxml"));
//
//        primaryStage.setScene(new Scene(root, 1280, 720));
//        Image icon = new Image(getClass().getResourceAsStream("../resources/img/logo.jpg"));
//        primaryStage.getIcons().add(icon);
//        primaryStage.setTitle("KUU");
//        primaryStage.show();
//    }
//}

import application.java.Student;

public class Main {
	private static final String DB_URL = "jdbc:sqlserver://localhost;databaseName=student;integratedSecurity=true";
	// Database credentials
	private static final String USER = "";
	private static final String PASS = "";

	public static void main(String[] args) {
		try {
            // connnect to database ''
            Connection conn = getConnection(DB_URL, USER, PASS);
            // crate statement
            
            Student s = new Student();
            
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select * from STUDENT");
            // show data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
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
}
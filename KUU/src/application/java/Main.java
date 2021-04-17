package src.application.java;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.awt.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
import src.heSo.*;
import src.heSo.hesoDat.*;
import src.heSo.hesoNha.*;
import src.nguoiDung.*;
import src.nha.*;
*/


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/dangky.fxml"));
		primaryStage.setScene(new Scene(root, 1280, 720));
		Image icon = new Image(getClass().getResourceAsStream("../resources/img/logo.jpg"));
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("KUU");
		primaryStage.show();
	}
}

/*
public class Main {
	public static void main(String[] args) {
		String hemTemp1 = "Hem 1";
		String hemTemp2 = "Hem 2";
		*/
//		Hem hem = new Hem(hemTemp1, (float)0.2);
//		Hem hem2 = new Hem(hemTemp2, (float)0.3);
//
//		hem.addHem();
//		hem2.addHem();
//		
//		//hem.delHem();
//			
//		hem.editHem(hem2);


		/*try {
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
	

}*/
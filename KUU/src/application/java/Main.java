package application.java;

//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.image.Image;


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
public class Main {
    public static void main(String[] args) {
       //launch(args);
       //tao nguoi dung quan tri
    	NguoiDung qt = new QuanTri("admin", "123456", "Tran Uy", "0123456789", "uy@gmail.com", null);
    	
    	//tao khach hang
        NguoiDung kh = new KhachHang("customer", "123456", "Tran Uy", "0123456789", "uy@gmail.com", null);
        
        
    }
}
package src.application.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.GUI.controller.ControllerDangNhap;

public class Main extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/home.fxml"));

        primaryStage.setScene(new Scene(root, 1280, 720));
        Image icon = new Image(getClass().getResourceAsStream("../../GUI/resources/img/logo.jpg"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("KUU");
        primaryStage.show();

        int id = 0;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../GUI/resources/fxml/timkiem.fxml"));
        Parent temp = loader.load();
        //ControllerDangNhap controllerDangNhap = loader.getController();
    }
}
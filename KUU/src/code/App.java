package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class App extends Application {
    double x, y = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setScene(new Scene(root, 1276, 892));
        Image icon = new Image(getClass().getResourceAsStream("../img/logo.jpg"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("KUU");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
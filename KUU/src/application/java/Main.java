package src.application.java;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.BUS.heSo.hesoDat.HemBUS;
import src.DAO.heSo.hesoDat.HemDAO;
import src.DTO.heSo.hesoDat.HemDTO;

import java.util.ArrayList;

public class Main extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/detailEditable.fxml"));

        primaryStage.setScene(new Scene(root, 1280, 720));
        Image icon = new Image(getClass().getResourceAsStream("../resources/img/logo.jpg"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("KUU");
        primaryStage.show();
        HemBUS hemBUS = new HemBUS();
        ArrayList<HemDTO> arrayList = hemBUS.danhsachHem();
        for (HemDTO h : arrayList) {
            System.out.println(h.getID() + " - " + h.getTenHem() + " - " + h.getHesoHem());
        }
    }
}
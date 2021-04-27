package src.application.java;

import javafx.application.*;
import javafx.stage.Stage;
import src.DAO.heSo.hesoDat.HemDAO;
import src.DTO.heSo.hesoDat.HemDTO;

import java.util.ArrayList;

public class Main extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/detailEditable.fxml"));
//
//        primaryStage.setScene(new Scene(root, 1280, 720));
//        Image icon = new Image(getClass().getResourceAsStream("../resources/img/logo.jpg"));
//        primaryStage.getIcons().add(icon);
//        primaryStage.setTitle("KUU");
//        primaryStage.show();
        HemDTO hemDTO = new HemDTO();
        HemDAO hemDAO = new HemDAO();
        ArrayList<HemDTO> arrayList = hemDTO.danhSachHem(hemDAO);
        for (HemDTO h : arrayList) {
            System.out.println(h.getID() + " - " + h.getTenHem() + " - " + h.getHesoHem());
        }
    }
}
package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import src.DTO.nha.DangBanNhaDTO;

import java.io.IOException;

public class PostController {
    private String id;
    @FXML
    private ImageView img;

    @FXML
    private Label address;

    @FXML
    private Label price;

    @FXML
    private JFXButton detail;

    public void setData(DangBanNhaDTO nha, String id) {
        String addrStr = nha.getSoNha() + " " + nha.getDuong() + ", Phường " + nha.getPhuong() + ", Quận" + nha.getQuan();
        address.setText(addrStr);
        price.setText(Float.toString(nha.getGiaTien()) + "Triệu Đồng");

        Image image = new javafx.scene.image.Image(getClass().getResourceAsStream(nha.getImgUrl()));
        img.setImage(image);
    }

    public void switchToDetail(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/detailHome.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

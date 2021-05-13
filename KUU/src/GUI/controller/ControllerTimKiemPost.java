package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import src.DTO.nha.DangBanNhaDTO;

import java.io.IOException;

public class ControllerTimKiemPost {

    public DangBanNhaDTO dangBanNhaDTO;
    @FXML
    private JFXTextField timkiem_post_sonha;
    @FXML
    private JFXTextField timkiem_post_duong;
    @FXML
    private JFXTextField timkiem_post_phuong;
    @FXML
    private JFXTextField timkiem_post_quan;
    @FXML
    private JFXTextField timkiem_post_giatien;
    @FXML
    private JFXButton tiemkiem_post_btn_xemchitiet;

    public void setData(DangBanNhaDTO dto) {
        this.dangBanNhaDTO = dto;
        timkiem_post_sonha.setText(dto.getSoNha());
        timkiem_post_duong.setText(dto.getDuong());
        timkiem_post_phuong.setText(dto.getPhuong());
        timkiem_post_quan.setText(dto.getQuan());
        timkiem_post_giatien.setText(dto.getGiaTien() + " Triệu đồng");
    }



    public void switchToDetail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../GUI/resources/fxml/detailHome.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllerDetail controllerDetail = loader.getController();
        controllerDetail.setHome(dangBanNhaDTO);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

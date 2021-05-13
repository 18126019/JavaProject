package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DAO.nha.DangBanNhaDAO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.DTO.nha.DangBanNhaDTO;
import src.application.java.UserSession;

import java.io.IOException;

public class ControllerThongtintaikhoanPost {

    public DangBanNhaDTO nhaDTO;

    @FXML
    private JFXTextField thongtintaikhoan_post_txt_diachi;
    @FXML
    private JFXButton thongtintaikhoan_post_btn_sua;
    @FXML
    private JFXButton thongtintaikhoan_post_btn_xoa;

    public void setData(DangBanNhaDTO dangBanNhaDTO, int id) {
        this.nhaDTO = dangBanNhaDTO;
        thongtintaikhoan_post_txt_diachi.setText(nhaDTO.getSoNha() +
                " đường " + nhaDTO.getDuong() +
                " phường " + nhaDTO.getPhuong() +
                " quận " + nhaDTO.getQuan());
    }


    public void switchToDetail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../GUI/resources/fxml/detailHome.fxml"));
        Parent root = loader.load();
        ControllerDetail controllerDetail = loader.getController();
        controllerDetail.setHome(this.nhaDTO);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void deleteDetail(ActionEvent event) throws IOException {
        String username = UserSession.getInstance("a").getUserName();
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        DangBanNhaDAO dangBanNhaDAO = new DangBanNhaDAO();
        dangBanNhaDAO.xoaNha(nhaDTO.getId(), khachHangDTO.layId(khachHangDAO, username));

        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/thongtintaikhoan.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

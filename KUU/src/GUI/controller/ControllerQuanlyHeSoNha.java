package src.GUI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.DAO.heSo.hesoDat.HemDAO;
import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.DAO.heSo.hesoDat.KhuDanCuDAO;
import src.DAO.heSo.hesoDat.MatTienDAO;
import src.DTO.heSo.hesoDat.HemDTO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.DTO.heSo.hesoDat.KhuDanCuDTO;
import src.DTO.heSo.hesoDat.MatTienDTO;
import src.application.java.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerQuanlyHeSoNha implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void logout(ActionEvent event) throws IOException {
        UserSession.clearUserSession();
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToNguoiDung(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/quanly_user.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToNhaDat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/quanly_nhadat.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHeSoDat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/quanlyhesodat.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    //    public void switchToHeSoNha(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/quanlyhesonha.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }

    // nút chức năng thêm xóa sửa
    public void switchToThemNha(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/themheso.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void xoaHeSo(ActionEvent event) {
        HemDTO hemDTO = quanly_hesodat_table_Hem.getSelectionModel().getSelectedItem();
        quanly_hesodat_table_Hem.getItems().remove(hemDTO);
        if (hemDTO != null) {
            hemDTO.xoaHem(new HemDAO(), hemDTO.getID());
        }

        HinhDangDTO hinhDangDTO = quanly_hesodat_table_HinhDang.getSelectionModel().getSelectedItem();
        quanly_hesodat_table_HinhDang.getItems().remove(hinhDangDTO);
        if (hinhDangDTO != null) {
            hinhDangDTO.xoaHinhDang(new HinhDangDAO(), hinhDangDTO.getId());

        }

        KhuDanCuDTO khuDanCuDTO = quanly_hesodat_table_KDC.getSelectionModel().getSelectedItem();
        quanly_hesodat_table_KDC.getItems().remove(khuDanCuDTO);
        if (khuDanCuDTO != null) {
            khuDanCuDTO.xoaKhuDanCu(new KhuDanCuDAO(), khuDanCuDTO.getId());
        }

        MatTienDTO matTienDTO = quanly_hesodat_table_MatTien.getSelectionModel().getSelectedItem();
        quanly_hesodat_table_KDC.getItems().remove(matTienDTO);
        if (matTienDTO != null) {
            matTienDTO.xoaMatTien(new MatTienDAO(), matTienDTO.getId());
        }
        quanly_hesodat_table_HinhDang.getSelectionModel().clearSelection();
        quanly_hesodat_table_Hem.getSelectionModel().clearSelection();
        quanly_hesodat_table_KDC.getSelectionModel().clearSelection();
        quanly_hesodat_table_MatTien.getSelectionModel().clearSelection();
    }

    public void clearHeSo(ActionEvent event) {
        quanly_hesodat_table_HinhDang.getSelectionModel().clearSelection();
        quanly_hesodat_table_Hem.getSelectionModel().clearSelection();
        quanly_hesodat_table_KDC.getSelectionModel().clearSelection();
        quanly_hesodat_table_MatTien.getSelectionModel().clearSelection();
    }
}

package src.GUI.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import src.BUS.nguoiDung.KhachHangBUS;
import src.DAO.nha.DangBanNhaDAO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.DTO.nha.DangBanNhaDTO;
import src.application.java.UserSession;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerDetail {

    @FXML
    private ImageView img;

    @FXML
    private JFXTextField tbChuNha;

    @FXML
    private JFXTextField tbSdt;

    @FXML
    private JFXTextField tbDienTich;

    @FXML
    private JFXTextField tbSoTang;

    @FXML
    private JFXTextField tbKetCau;

    @FXML
    private JFXTextField tbSoNha;

    @FXML
    private JFXTextField tbDuong;

    @FXML
    private JFXTextField tbPhuong;

    @FXML
    private JFXTextField tbQuan;

    @FXML
    private JFXTextField tbGiaTien;

    @FXML
    private JFXTextArea tbGhiChu;

    public void setHome(DangBanNhaDTO nha) {
        KhachHangBUS kh = new KhachHangBUS();
        ArrayList<KhachHangDTO> dsKH = kh.danhSachKhachHang();
        for(int i = 0; i < dsKH.size(); i++) {
            if(nha.getId_khachang() == dsKH.get(i).getId()) {
                tbChuNha.setText(dsKH.get(i).getHoTen());
                tbSdt.setText(dsKH.get(i).getSdt());
            }
        }
        tbSoNha.setText(nha.getSoNha());
        tbDuong.setText(nha.getDuong());
        tbPhuong.setText(nha.getPhuong());
        tbQuan.setText(nha.getQuan());
        tbGiaTien.setText(Float.toString(nha.getGiaTien()) + " Triệu Đồng");
        tbDienTich.setText(Float.toString(nha.getDienTich()));
        tbSoTang.setText(Float.toString(nha.getSoTang()));
        tbKetCau.setText(nha.getKetcau());
        tbGhiChu.setText(nha.getGhichu());
        Image image = new javafx.scene.image.Image(getClass().getResourceAsStream(nha.getImgUrl()));
        img.setImage(image);
    }

    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDetail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/detailHome.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAccount(ActionEvent event) throws IOException {
        String name = UserSession.getInstance("a").getUserName();
        System.out.println(name);
        if(!name.equals("a")) {
            Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/thongtintaikhoan.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else {
            UserSession.clearUserSession();
            Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/login.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToSetting(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/setting.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDinhGia(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/dinhgia.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSearch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/timkiem.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAddHome(ActionEvent event) throws IOException {
        String name = UserSession.getInstance("a").getUserName();
        System.out.println(name);
        if(!name.equals("a")) {
            Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/themNha.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else {
            UserSession.clearUserSession();
            Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/login.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
}

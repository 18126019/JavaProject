package src.GUI.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DAO.nha.DangBanNhaDAO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.DTO.nha.DangBanNhaDTO;
import src.application.java.UserSession;

import java.io.File;
import java.io.IOException;

public class ControllerThemNha {
    private String url;
    @FXML
    private ImageView img;

    @FXML
    private JFXTextField tbDienTich;

    @FXML
    private JFXTextField tbSoTang;

    @FXML
    private JFXTextField tbGiaTien;

    @FXML
    private JFXTextField tbSoNha;

    @FXML
    private JFXTextField tbDuong;

    @FXML
    private JFXTextField tbPhuong;

    @FXML
    private JFXTextField tbQuan;

    @FXML
    private JFXTextField tbKetCau;

    @FXML
    private JFXTextArea tbGhiChu;

    public void chooseImage(ActionEvent e) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose a image");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fc.getExtensionFilters().add(imageFilter);

        File file = fc.showOpenDialog(null);
        if (file != null){
            Image image = new Image(file.toURI().toString(),320, 213, false, true);
            String[] temp = file.toURI().toString().split("resources");
            this.url = "../resources" + temp[1];
            img.setImage(image);
        }
    }
    public void addHome(ActionEvent event) throws IOException {
        KhachHangDAO kh = new KhachHangDAO();
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        DangBanNhaDAO nha = new DangBanNhaDAO();
        int userId = khachHangDTO.layId(kh, UserSession.getInstance("a").getUserName());

        nha.setMaNguoiDung(userId);
        nha.setDienTich(Float.parseFloat(tbDienTich.getText()));
        nha.setSoTang(Float.parseFloat(tbSoTang.getText()));
        nha.setKetCau(tbKetCau.getText());
        nha.setSoNha(tbSoNha.getText());
        nha.setDuong(tbDuong.getText());
        nha.setPhuong(tbPhuong.getText());
        nha.setQuan(tbQuan.getText());
        nha.setGiaTien(Float.parseFloat(tbGiaTien.getText()));
        nha.setGhiChu(tbGhiChu.getText());
        nha.setImgUrl(this.url);
        nha.setDaXoa(0);

        kh.themNha(nha);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Thêm nhà thành công");
        alert.show();
        switchToHome(event);
    }

    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println(UserSession.getInstance("a").toString());
    }

    public void switchToDetail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/detailHome.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void switchToDetailEditable(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/detailEditable.fxml"));
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

    }
}

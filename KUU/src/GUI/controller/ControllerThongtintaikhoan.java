package src.GUI.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import src.BUS.nha.DangBanNhaBUS;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.DTO.nha.DangBanNhaDTO;
import src.application.java.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerThongtintaikhoan implements Initializable {

    @FXML
    private JFXTextField thongtintaikhoan_txt_hoten;
    @FXML
    private JFXTextField thongtintaikhoan_txt_sdt;
    @FXML
    private JFXTextField thongtintaikhoan_txt_email;
    @FXML
    private GridPane thongtintaikhoan_grid;
    private String username = UserSession.getInstance("a").getUserName();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println(username);
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        thongtintaikhoan_txt_email.setText(khachHangDTO.layEmail(khachHangDAO, username));
        thongtintaikhoan_txt_hoten.setText(khachHangDTO.layTen(khachHangDAO, username));
        thongtintaikhoan_txt_sdt.setText(khachHangDTO.laySdt(khachHangDAO, username));


        DangBanNhaBUS dangBanNhaBUS = new DangBanNhaBUS();
        ArrayList<DangBanNhaDTO> dangBanNhaDTO = dangBanNhaBUS.danhSachDangBanNha();
        int column = 0;
        int row = 1;

        for(int i = 0; i < dangBanNhaDTO.size(); i++) {
            System.out.println(dangBanNhaDTO.get(i).getDaXoa());
            if (dangBanNhaDTO.get(i).getId_khachang() == khachHangDTO.layId(khachHangDAO,username)
            && dangBanNhaDTO.get(i).getDaXoa() == 0) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../resources/fxml/thongtintaikhoan_post.fxml"));

                AnchorPane anchorPane = null;
                try {
                    anchorPane = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ControllerThongtintaikhoanPost controller = fxmlLoader.getController();
                controller.setData(dangBanNhaDTO.get(i), dangBanNhaDTO.get(i).getId());


                thongtintaikhoan_grid.add(anchorPane, column, row++);
                thongtintaikhoan_grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                thongtintaikhoan_grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                thongtintaikhoan_grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                thongtintaikhoan_grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                thongtintaikhoan_grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                thongtintaikhoan_grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }
    }

    public void logout(ActionEvent event) throws IOException {
        UserSession.clearUserSession();
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
            UserSession.getInstance("a").cleanUserSession();
            Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/login.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
}

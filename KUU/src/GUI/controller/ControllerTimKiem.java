package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import src.BUS.heSo.DonGiaNnBUS;
import src.BUS.nha.DangBanNhaBUS;
import src.DTO.heSo.DonGiaNnDTO;
import src.DTO.nha.DangBanNhaDTO;
import src.application.java.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

public class ControllerTimKiem implements Initializable {

    @FXML
    private JFXComboBox timkiem_duong;
    @FXML
    private JFXComboBox timkiem_quan;
    @FXML
    private JFXComboBox timkiem_phuong;
    @FXML
    private JFXButton timkiem_btn_timkiem;
    @FXML
    private GridPane timkiem_grid;

    final int userSessionId =  1; //UserSession.getInstance("a").getId();

    DangBanNhaBUS dangBanNhaBUS = new DangBanNhaBUS();
    DonGiaNnBUS donGiaNnBUS = new DonGiaNnBUS();
    ArrayList<DangBanNhaDTO> dsTimKiem = new ArrayList<>();

    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            String duong = null;
            String quan = null;
            String phuong = null;
            if (timkiem_duong.getValue() != null) {
                duong = timkiem_duong.getValue().toString();
            }
            if (timkiem_quan.getValue() != null) {
                quan = timkiem_quan.getValue().toString();
            }
            if (timkiem_phuong.getValue() != null) {
                phuong = timkiem_phuong.getValue().toString();
            }


            if (duong != null || quan != null || phuong != null) {
                for (DangBanNhaDTO dangBanNhaDTO : dangBanNhaBUS.danhSachDangBanNha()) {
                    if (dangBanNhaDTO.getDuong().equals(duong)
                            || dangBanNhaDTO.getQuan().equals(quan)
                            || dangBanNhaDTO.getDuong().equals(duong)
                            || dangBanNhaDTO.getId_khachang() == userSessionId) {
                        dsTimKiem.add(dangBanNhaDTO);
                    }
                }
            } else {
                for (DangBanNhaDTO dangBanNhaDTO : dangBanNhaBUS.danhSachDangBanNha()) {
                    //if (dangBanNhaDTO.getId() == userSessionId) {
                        dsTimKiem.add(dangBanNhaDTO);
                    //}
                }
            }
            int column = 0;
            int row = 1;
            for (int i = 0; i < dsTimKiem.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../resources/fxml/timkiem_post.fxml"));

                AnchorPane anchorPane = null;
                try {
                    anchorPane = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ControllerTimKiemPost controllerTimKiemPost = fxmlLoader.getController();
                controllerTimKiemPost.setData(dsTimKiem.get(i));

                timkiem_grid.add(anchorPane, column, row++);
                timkiem_grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                timkiem_grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                timkiem_grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                timkiem_grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                timkiem_grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                timkiem_grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }
    };




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //đường
        ArrayList<String> d = new ArrayList<>();
        for (DonGiaNnDTO h : donGiaNnBUS.danhsachDonGiaNn()) {
            d.add(h.getDuong());
        }
        ArrayList<String> duong = new ArrayList<>(new HashSet<>(d));
        for (String h : duong) {
            timkiem_duong.getItems().add(h);
        }
        //quận
        ArrayList<String> p = new ArrayList<>();
        for (DonGiaNnDTO h : donGiaNnBUS.danhsachDonGiaNn()) {
            p.add(h.getQuan());
        }
        ArrayList<String> phuong = new ArrayList<>(new HashSet<>(p));
        for (String h : phuong) {
            timkiem_quan.getItems().add(h);
        }
        //phường
        ArrayList<String> q = new ArrayList<>();
        for (DangBanNhaDTO h : dangBanNhaBUS.danhSachDangBanNha()) {
            q.add(h.getPhuong());
        }
        ArrayList<String> quan = new ArrayList<>(new HashSet<>(q));
        for (String h : quan) {
            timkiem_phuong.getItems().add(h);
        }

        timkiem_btn_timkiem.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}

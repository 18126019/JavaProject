package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import src.BUS.heSo.DonGiaNnBUS;
import src.BUS.nha.DangBanNhaBUS;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.heSo.DonGiaNnDTO;
import src.DTO.nguoiDung.KhachHangDTO;
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

    private String username = UserSession.getInstance("a").getUserName();
    KhachHangDTO khachHangDTO = new KhachHangDTO();
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    final private int userSessionId = khachHangDTO.layId(khachHangDAO, username);
    DangBanNhaBUS dangBanNhaBUS = new DangBanNhaBUS();
    DonGiaNnBUS donGiaNnBUS = new DonGiaNnBUS();


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
            ArrayList<DangBanNhaDTO> dsTimKiem = new ArrayList<>();
            dsTimKiem.clear();
            timkiem_grid.getChildren().clear();

            for (DangBanNhaDTO dangBanNhaDTO : dangBanNhaBUS.danhSachDangBanNha()) {
                if (dangBanNhaDTO.getDaXoa() == 0) {
                    if (duong == null && quan == null && phuong == null) {
                        dsTimKiem.add(dangBanNhaDTO);
                    } else if (duong != null && dangBanNhaDTO.getDuong().equals(duong) && quan == null && phuong == null) {
                        dsTimKiem.add(dangBanNhaDTO);
                    } else if (quan != null && dangBanNhaDTO.getQuan().equals(quan) && duong == null && phuong == null) {
                        dsTimKiem.add(dangBanNhaDTO);
                    } else if (phuong != null && dangBanNhaDTO.getPhuong().equals(phuong) && duong == null && quan == null) {
                        dsTimKiem.add(dangBanNhaDTO);
                    } else if (duong != null && quan != null
                            && dangBanNhaDTO.getDuong().equals(duong)
                            && dangBanNhaDTO.getQuan().equals(quan)
                            && phuong == null) {
                        dsTimKiem.add(dangBanNhaDTO);
                    } else if (duong != null && phuong != null
                            && dangBanNhaDTO.getDuong().equals(duong)
                            && dangBanNhaDTO.getPhuong().equals(phuong)
                            && quan == null) {
                        dsTimKiem.add(dangBanNhaDTO);
                    } else if (phuong != null && quan != null
                            && dangBanNhaDTO.getPhuong().equals(phuong)
                            && dangBanNhaDTO.getQuan().equals(quan)
                            && duong == null) {
                        dsTimKiem.add(dangBanNhaDTO);
                    } else if (duong != null && quan != null && phuong != null
                            && dangBanNhaDTO.getDuong().equals(duong)
                            && dangBanNhaDTO.getQuan().equals(quan)
                            && dangBanNhaDTO.getPhuong().equals(phuong)){
                        dsTimKiem.add(dangBanNhaDTO);
                    }
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

package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import src.BUS.heSo.hesoDat.KhuDanCuBUS;
import src.DAO.heSo.HeSoNcDAO;
import src.DAO.heSo.hesoDat.HemDAO;
import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.DAO.heSo.hesoDat.KhuDanCuDAO;
import src.DAO.heSo.hesoDat.MatTienDAO;
import src.DAO.heSo.hesoNha.KetCauDAO;
import src.DAO.heSo.hesoNha.NoiThatDAO;
import src.DAO.heSo.hesoNha.TinhTrangDAO;
import src.DTO.heSo.HeSoNcDTO;
import src.DTO.heSo.hesoDat.HemDTO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.DTO.heSo.hesoDat.KhuDanCuDTO;
import src.DTO.heSo.hesoDat.MatTienDTO;
import src.DTO.heSo.hesoNha.KetCauDTO;
import src.DTO.heSo.hesoNha.NoiThatDTO;
import src.DTO.heSo.hesoNha.TinhTrangDTO;
import src.application.java.UserSession;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerQuanlyHeSoThem implements Initializable {

    @FXML
    private JFXComboBox quanly_heso_them_loai;
    @FXML
    private JFXTextField quanly_heso_them_txt_ten;
    @FXML
    private JFXTextField quanly_heso_them_txt_giatri;
    @FXML
    private JFXButton quanly_heso_them_btn_them;
    @FXML
    private JFXButton quanly_heso_them_btn_huy;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quanly_heso_them_loai.getItems().add("Hẻm");
        quanly_heso_them_loai.getItems().add("Hình Dạng");
        quanly_heso_them_loai.getItems().add("Khu Dân Cư");
        quanly_heso_them_loai.getItems().add("Mặt tiền");
        quanly_heso_them_loai.getItems().add("Kết Cấu");
        quanly_heso_them_loai.getItems().add("Nội Thất");
        quanly_heso_them_loai.getItems().add("Tình Trạng");
        quanly_heso_them_loai.getItems().add("Ngoại Cảnh");

        quanly_heso_them_btn_them.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            String loaiHeSo = quanly_heso_them_loai.getValue().toString();
            String tenHeSo = quanly_heso_them_txt_ten.getText();
            Float giatriHeSo = Float.parseFloat(quanly_heso_them_txt_giatri.getText());

            if (loaiHeSo.equals("Hẻm")) {
                HemDTO hemDTO = new HemDTO();
                hemDTO.themHem(new HemDAO(), tenHeSo, giatriHeSo);
                quanly_heso_them_txt_ten.clear();
                quanly_heso_them_txt_giatri.clear();
            }
            else if (loaiHeSo.equals("Hình Dạng")) {
                HinhDangDTO hinhDangDTO = new HinhDangDTO();
                hinhDangDTO.themHinhDang(new HinhDangDAO(), tenHeSo, giatriHeSo);
            }
            else if (loaiHeSo.equals("Khu Dân Cư")) {
                KhuDanCuDTO khuDanCuDTO = new KhuDanCuDTO();
                khuDanCuDTO.themKDC(new KhuDanCuDAO(), tenHeSo, giatriHeSo);
            }
            else if (loaiHeSo.equals("Mặt Tiền")) {
                MatTienDTO matTienDTO = new MatTienDTO();
                matTienDTO.themMatTien(new MatTienDAO(), tenHeSo, giatriHeSo);
            }
            else if (loaiHeSo.equals("Kết Cấu")) {
                KetCauDTO ketCauDTO = new KetCauDTO();
                ketCauDTO.themKetCau(new KetCauDAO(), tenHeSo, giatriHeSo);
            }
            else if (loaiHeSo.equals("Nội Thất")) {
                NoiThatDTO noiThatDTO = new NoiThatDTO();
                noiThatDTO.themNoiThat(new NoiThatDAO(), tenHeSo, giatriHeSo);
            }
            else if (loaiHeSo.equals("Tình Trạng")) {
                TinhTrangDTO tinhTrangDTO = new TinhTrangDTO();
                tinhTrangDTO.themTinhTrang(new TinhTrangDAO(), tenHeSo, giatriHeSo);
            }
            else if (loaiHeSo.equals("Ngoại Cảnh")) {
                HeSoNcDTO heSoNcDTO = new HeSoNcDTO();
                heSoNcDTO.themNgoaiCanh(new HeSoNcDAO(), tenHeSo, giatriHeSo);
            }
        }
    };

    public void huyHeSo(ActionEvent event) {
        quanly_heso_them_loai.getItems().clear();
        quanly_heso_them_txt_ten.clear();
        quanly_heso_them_txt_giatri.clear();
    }

    // điều hướng
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
}

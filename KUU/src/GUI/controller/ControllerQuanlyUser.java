package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import src.BUS.nguoiDung.KhachHangBUS;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.application.java.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerQuanlyUser implements Initializable {

    @FXML
    private TableView<KhachHangDTO> quanly_user_table_user;
    @FXML
    private TableColumn quanly_user_col_id;
    @FXML
    private TableColumn quanly_user_col_taikhoan;
    @FXML
    private TableColumn quanly_user_col_matkhau;
    @FXML
    private TableColumn quanly_user_col_ten;
    @FXML
    private TableColumn quanly_user_col_email;
    @FXML
    private TableColumn quanly_user_col_sdt;
    @FXML
    private TableColumn quanly_user_col_daxoa;
    @FXML
    private JFXButton quanly_user_btn_timkiem;
    @FXML
    private JFXTextField quanly_user_txt_timkiem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        KhachHangBUS khachHangBUS = new KhachHangBUS();
        quanly_user_table_user.setEditable(true);
        quanly_user_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        quanly_user_col_taikhoan.setCellValueFactory(new PropertyValueFactory<>("tenDangNhap"));
        quanly_user_col_taikhoan.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_user_col_matkhau.setCellValueFactory(new PropertyValueFactory<>("matKhau"));
        quanly_user_col_ten.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        quanly_user_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        quanly_user_col_sdt.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        quanly_user_col_daxoa.setCellValueFactory(new PropertyValueFactory<>("daXoa"));


        for (KhachHangDTO khachHangDTO : khachHangBUS.danhSachKhachHang()) {
            quanly_user_table_user.getItems().add(khachHangDTO);
        }
    }

    public void editTaiKhoan(TableColumn.CellEditEvent<KhachHangDTO, String> editKh) {
        KhachHangDTO khachHangDTO = quanly_user_table_user.getSelectionModel().getSelectedItem();
        khachHangDTO.setTenDangNhap(editKh.getNewValue());
        khachHangDTO.updateTaiKhoan(new KhachHangDAO(), editKh.getNewValue(), khachHangDTO.getId());
    }
    public void logout(ActionEvent event) throws IOException {
        UserSession.clearUserSession();
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/home.fxml"));
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
}

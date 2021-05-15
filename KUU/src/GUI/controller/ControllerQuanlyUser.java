package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import src.BUS.nguoiDung.KhachHangBUS;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.application.java.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControllerQuanlyUser implements Initializable {

    @FXML
    private TableView<KhachHangDTO> quanly_user_table_user;
    @FXML
    private TableColumn<KhachHangDTO, String> quanly_user_col_id;
    @FXML
    private TableColumn<KhachHangDTO, String> quanly_user_col_taikhoan;
    @FXML
    private TableColumn<KhachHangDTO, String> quanly_user_col_matkhau;
    @FXML
    private TableColumn<KhachHangDTO, String> quanly_user_col_ten;
    @FXML
    private TableColumn<KhachHangDTO, String> quanly_user_col_email;
    @FXML
    private TableColumn<KhachHangDTO, String> quanly_user_col_sdt;
    @FXML
    private TableColumn<KhachHangDTO, Integer> quanly_user_col_daxoa;
    @FXML
    private JFXTextField quanly_user_txt_timkiem;

    private KhachHangBUS khachHangBUS = new KhachHangBUS();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        quanly_user_table_user.setEditable(true);
        quanly_user_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        quanly_user_col_taikhoan.setCellValueFactory(new PropertyValueFactory<>("tenDangNhap"));
        quanly_user_col_taikhoan.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_user_col_matkhau.setCellValueFactory(new PropertyValueFactory<>("matKhau"));
        quanly_user_col_matkhau.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_user_col_ten.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        quanly_user_col_ten.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_user_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        quanly_user_col_email.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_user_col_sdt.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        quanly_user_col_sdt.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_user_col_daxoa.setCellValueFactory(new PropertyValueFactory<>("daXoa"));
        quanly_user_col_daxoa.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //hiển thị data
        for (KhachHangDTO khachHangDTO : khachHangBUS.danhSachKhachHang()) {
            quanly_user_table_user.getItems().add(khachHangDTO);
        }
        //sort + filter
        ObservableList<KhachHangDTO> list = FXCollections.observableArrayList(khachHangBUS.danhSachKhachHang());
        FilteredList<KhachHangDTO> filteredList = new FilteredList<>(list, p -> true);
        quanly_user_txt_timkiem.textProperty().addListener((observable, newValue, oldValue) -> {
            filteredList.setPredicate(khachHang -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String low = newValue.toLowerCase();
                if (khachHang.getEmail().toLowerCase().contains(low)) {
                    return true;
                }
                else if (khachHang.getTenDangNhap().toLowerCase().contains(low)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<KhachHangDTO> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(quanly_user_table_user.comparatorProperty());
        quanly_user_table_user.setItems(sortedList);
    }

    public void editTaiKhoan(TableColumn.CellEditEvent<KhachHangDTO, String> editTk) {
        KhachHangDTO khachHangDTO = quanly_user_table_user.getSelectionModel().getSelectedItem();
        khachHangDTO.setTenDangNhap(editTk.getNewValue());
        khachHangDTO.updateTaiKhoan(new KhachHangDAO(), editTk.getNewValue(), khachHangDTO.getId());
    }

    public void editMatKhau(TableColumn.CellEditEvent<KhachHangDTO, String> editMk) {
        KhachHangDTO khachHangDTO = quanly_user_table_user.getSelectionModel().getSelectedItem();
        khachHangDTO.setMatKhau(editMk.getNewValue());
        khachHangDTO.updateMatKhau(new KhachHangDAO(), editMk.getNewValue(), khachHangDTO.getId());
    }
    public void editHoTen(TableColumn.CellEditEvent<KhachHangDTO, String> editHt) {
        KhachHangDTO khachHangDTO = quanly_user_table_user.getSelectionModel().getSelectedItem();
        khachHangDTO.setHoTen(editHt.getNewValue());
        khachHangDTO.updateHoTen(new KhachHangDAO(), editHt.getNewValue(), khachHangDTO.getId());
    }
    public void editEmail(TableColumn.CellEditEvent<KhachHangDTO, String> editEmail) {
        KhachHangDTO khachHangDTO = quanly_user_table_user.getSelectionModel().getSelectedItem();
        khachHangDTO.setEmail(editEmail.getNewValue());
        khachHangDTO.updateEmail(new KhachHangDAO(), editEmail.getNewValue(), khachHangDTO.getId());
    }
    public void editSdt(TableColumn.CellEditEvent<KhachHangDTO, String> editSdt) {
        KhachHangDTO khachHangDTO = quanly_user_table_user.getSelectionModel().getSelectedItem();
        khachHangDTO.setSdt(editSdt.getNewValue());
        khachHangDTO.updateSdt(new KhachHangDAO(), editSdt.getNewValue(), khachHangDTO.getId());
    }
    public void editDaXoa(TableColumn.CellEditEvent<KhachHangDTO, Integer> editDx) {
        KhachHangDTO khachHangDTO = quanly_user_table_user.getSelectionModel().getSelectedItem();
        khachHangDTO.setDaXoa(editDx.getNewValue());
        khachHangDTO.updateDaXoa(new KhachHangDAO(), editDx.getNewValue(), khachHangDTO.getId());
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
    public void switchToHeSoDat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/quanlyheso.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import src.BUS.nguoiDung.KhachHangBUS;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.nguoiDung.KhachHangDTO;

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
        quanly_user_col_matkhau.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_user_col_ten.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        quanly_user_col_ten.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_user_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        quanly_user_col_email.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_user_col_sdt.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        quanly_user_col_sdt.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_user_col_daxoa.setCellValueFactory(new PropertyValueFactory<>("daXoa"));
        quanly_user_col_daxoa.setCellFactory(TextFieldTableCell.forTableColumn());


        for (KhachHangDTO khachHangDTO : khachHangBUS.danhSachKhachHang()) {
            quanly_user_table_user.getItems().add(khachHangDTO);
        }
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
    public void editDaXoa(TableColumn.CellEditEvent<KhachHangDTO, String> editDx) {
        KhachHangDTO khachHangDTO = quanly_user_table_user.getSelectionModel().getSelectedItem();
        khachHangDTO.setDaXoa(Integer.parseInt(editDx.getNewValue()));
        khachHangDTO.updateDaXoa(new KhachHangDAO(), editDx.getNewValue(), khachHangDTO.getId());
    }
}

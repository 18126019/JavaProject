package src.GUI.controller;

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
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import src.BUS.nha.DangBanNhaBUS;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DAO.nha.DangBanNhaDAO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.DTO.nha.DangBanNhaDTO;
import src.application.java.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerQuanlyNhadat implements Initializable {

    @FXML
    private TableView<DangBanNhaDTO> quanly_nhadat_table_nhadat;
    @FXML
    private TableColumn quanly_nhadat_col_id;
    @FXML
    private TableColumn quanly_nhadat_col_sonha;
    @FXML
    private TableColumn quanly_nhadat_col_duong;
    @FXML
    private TableColumn quanly_nhadat_col_phuong;
    @FXML
    private TableColumn quanly_nhadat_col_quan;
    @FXML
    private TableColumn quanly_nhadat_col_dientich;
    @FXML
    private TableColumn quanly_nhadat_col_sotang;
    @FXML
    private TableColumn quanly_nhadat_col_giatien;
    @FXML
    private TableColumn quanly_nhadat_col_ghichu;
    @FXML
    private TableColumn quanly_nhadat_col_daxoa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quanly_nhadat_table_nhadat.setEditable(true);
        DangBanNhaBUS dangBanNhaBUS = new DangBanNhaBUS();
        quanly_nhadat_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));

        quanly_nhadat_col_sonha.setCellValueFactory(new PropertyValueFactory<>("soNha"));
        quanly_nhadat_col_sonha.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_nhadat_col_duong.setCellValueFactory(new PropertyValueFactory<>("duong"));
        quanly_nhadat_col_duong.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_nhadat_col_phuong.setCellValueFactory(new PropertyValueFactory<>("phuong"));
        quanly_nhadat_col_phuong.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_nhadat_col_quan.setCellValueFactory(new PropertyValueFactory<>("quan"));
        quanly_nhadat_col_quan.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_nhadat_col_dientich.setCellValueFactory(new PropertyValueFactory<>("dienTich"));
        quanly_nhadat_col_dientich.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        quanly_nhadat_col_sotang.setCellValueFactory(new PropertyValueFactory<>("soTang"));
        quanly_nhadat_col_sotang.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        quanly_nhadat_col_giatien.setCellValueFactory(new PropertyValueFactory<>("giaTien"));
        quanly_nhadat_col_giatien.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        quanly_nhadat_col_ghichu.setCellValueFactory(new PropertyValueFactory<>("ghichu"));
        quanly_nhadat_col_ghichu.setCellFactory(TextFieldTableCell.forTableColumn());

        quanly_nhadat_col_daxoa.setCellValueFactory(new PropertyValueFactory<>("daXoa"));
        quanly_nhadat_col_daxoa.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        for (DangBanNhaDTO dangBanNhaDTO : dangBanNhaBUS.danhSachDangBanNha()) {
            quanly_nhadat_table_nhadat.getItems().add(dangBanNhaDTO);
        }
    }

    public void editSoNha(TableColumn.CellEditEvent<DangBanNhaDTO, String> editNha) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setSoNha(editNha.getNewValue());
        dangBanNhaDTO.updateSoNha(new DangBanNhaDAO(), editNha.getNewValue(), dangBanNhaDTO.getId());
    }
    public void editDuong(TableColumn.CellEditEvent<DangBanNhaDTO, String> editDuong) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setDuong(editDuong.getNewValue());
        dangBanNhaDTO.updateDuong(new DangBanNhaDAO(), editDuong.getNewValue(), dangBanNhaDTO.getId());
    }
    public void editPhuong(TableColumn.CellEditEvent<DangBanNhaDTO, String> editPhuong) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setPhuong(editPhuong.getNewValue());
        dangBanNhaDTO.updatePhuong(new DangBanNhaDAO(), editPhuong.getNewValue(), dangBanNhaDTO.getId());
    }
    public void editQuan(TableColumn.CellEditEvent<DangBanNhaDTO, String> editQuan) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setQuan(editQuan.getNewValue());
        dangBanNhaDTO.updateQuan(new DangBanNhaDAO(), editQuan.getNewValue(), dangBanNhaDTO.getId());
    }
    public void editGhiChu(TableColumn.CellEditEvent<DangBanNhaDTO, String> editGhiChu) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setGhichu(editGhiChu.getNewValue());
        dangBanNhaDTO.updateGhiChu(new DangBanNhaDAO(), editGhiChu.getNewValue(), dangBanNhaDTO.getId());
    }

    public void editDienTich(TableColumn.CellEditEvent<DangBanNhaDTO, Float> editNha) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setDienTich(editNha.getNewValue());
        dangBanNhaDTO.updateDienTich(new DangBanNhaDAO(), editNha.getNewValue(), dangBanNhaDTO.getId());
    }

    public void editSoTang(TableColumn.CellEditEvent<DangBanNhaDTO, Float> editNha) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setSoTang(editNha.getNewValue());
        dangBanNhaDTO.updateSoTang(new DangBanNhaDAO(), editNha.getNewValue(), dangBanNhaDTO.getId());
    }

    public void editGiaTien(TableColumn.CellEditEvent<DangBanNhaDTO, Float> editNha) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setGiaTien(editNha.getNewValue());
        dangBanNhaDTO.updateGiaTien(new DangBanNhaDAO(), editNha.getNewValue(), dangBanNhaDTO.getId());
    }

    public void editDaXoa(TableColumn.CellEditEvent<KhachHangDTO, Integer> editDx) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setDaXoa(editDx.getNewValue());
        dangBanNhaDTO.updateDaXoa(new DangBanNhaDAO(), editDx.getNewValue(), dangBanNhaDTO.getId());
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
    public void switchToHeSoDat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/quanlyheso.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

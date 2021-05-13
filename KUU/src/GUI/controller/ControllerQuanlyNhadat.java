package src.GUI.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.BUS.nha.DangBanNhaBUS;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DAO.nha.DangBanNhaDAO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.DTO.nha.DangBanNhaDTO;

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
        quanly_nhadat_col_duong.setCellValueFactory(new PropertyValueFactory<>("duong"));
        quanly_nhadat_col_phuong.setCellValueFactory(new PropertyValueFactory<>("phuong"));
        quanly_nhadat_col_quan.setCellValueFactory(new PropertyValueFactory<>("quan"));
        quanly_nhadat_col_dientich.setCellValueFactory(new PropertyValueFactory<>("dienTich"));
        quanly_nhadat_col_sotang.setCellValueFactory(new PropertyValueFactory<>("soTang"));
        quanly_nhadat_col_giatien.setCellValueFactory(new PropertyValueFactory<>("giaTien"));
        quanly_nhadat_col_ghichu.setCellValueFactory(new PropertyValueFactory<>("ghiChu"));
        quanly_nhadat_col_daxoa.setCellValueFactory(new PropertyValueFactory<>("daXoa"));
        for (DangBanNhaDTO dangBanNhaDTO : dangBanNhaBUS.danhSachDangBanNha()) {
            quanly_nhadat_table_nhadat.getItems().add(dangBanNhaDTO);
        }
    }

    public void editSoNha(TableColumn.CellEditEvent<DangBanNhaDTO, String> editNha) {
        DangBanNhaDTO dangBanNhaDTO = quanly_nhadat_table_nhadat.getSelectionModel().getSelectedItem();
        dangBanNhaDTO.setSoNha(editNha.getNewValue());
        dangBanNhaDTO.updateSoNha(new DangBanNhaDAO(), editNha.getNewValue(), dangBanNhaDTO.getId());
    }
}

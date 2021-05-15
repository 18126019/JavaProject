package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
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
import src.BUS.heSo.HeSoNcBUS;
import src.BUS.heSo.hesoNha.KetCauBUS;
import src.BUS.heSo.hesoNha.NoiThatBUS;
import src.BUS.heSo.hesoNha.TinhTrangBUS;
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

public class ControllerQuanlyHeSoNha implements Initializable {

    @FXML
    private JFXButton quanly_btn_nguoidung;
    @FXML
    private JFXButton quanly_btn_nhadat;
    @FXML
    private JFXButton quanly_btn_hesodat;
    @FXML
    private JFXButton quanly_btn_hesonha;

    @FXML
    private TableView<KetCauDTO> quanly_hesonha_table_KetCau;
    @FXML
    private TableColumn<KetCauDTO, String> quanly_hesonha_col_KetCau_ten;
    @FXML
    private TableColumn<KetCauDTO, Float> quanly_hesonha_col_KetCau_giatri;
    private KetCauBUS ketCauBUS = new KetCauBUS();

    @FXML
    private TableView<NoiThatDTO> quanly_hesonha_table_NoiThat;
    @FXML
    private TableColumn<NoiThatDTO, String> quanly_hesonha_col_NoiThat_ten;
    @FXML
    private TableColumn<NoiThatDTO, Float> quanly_hesonha_col_NoiThat_giatri;
    private NoiThatBUS noiThatBUS = new NoiThatBUS();

    @FXML
    private TableView<TinhTrangDTO> quanly_hesonha_table_TinhTrang;
    @FXML
    private TableColumn<TinhTrangDTO, String> quanly_hesonha_col_TinhTrang_ten;
    @FXML
    private TableColumn<TinhTrangDTO, Float> quanly_hesonha_col_TinhTrang_giatri;
    private TinhTrangBUS tinhTrangBUS = new TinhTrangBUS();

    @FXML
    private TableView<HeSoNcDTO> quanly_hesonha_table_NgoaiCanh;
    @FXML
    private TableColumn<HeSoNcDTO, String> quanly_hesonha_col_NgoaiCanh_ten;
    @FXML
    private TableColumn<HeSoNcDTO, Float> quanly_hesonha_col_NgoaiCanh_giatri;
    private HeSoNcBUS heSoNcBUS = new HeSoNcBUS();

    @FXML
    private JFXButton quanly_heso_btn_xoa;
    @FXML
    private JFXButton quanly_heso_btn_them;
    @FXML
    private JFXButton quanly_heso_btn_clear;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quanly_hesonha_table_KetCau.setEditable(true);
        quanly_hesonha_table_NgoaiCanh.setEditable(true);
        quanly_hesonha_table_NoiThat.setEditable(true);
        quanly_hesonha_table_TinhTrang.setEditable(true);

        quanly_hesonha_col_KetCau_ten.setCellValueFactory(new PropertyValueFactory<>("tenKetCau"));
        quanly_hesonha_col_KetCau_ten.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_hesonha_col_KetCau_giatri.setCellValueFactory(new PropertyValueFactory<>("hesoKetCau"));
        quanly_hesonha_col_KetCau_giatri.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        quanly_hesonha_col_NoiThat_ten.setCellValueFactory(new PropertyValueFactory<>("tenNoiThat"));
        quanly_hesonha_col_NoiThat_ten.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_hesonha_col_NoiThat_giatri.setCellValueFactory(new PropertyValueFactory<>("hesoNoiThat"));
        quanly_hesonha_col_NoiThat_giatri.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        quanly_hesonha_col_TinhTrang_ten.setCellValueFactory(new PropertyValueFactory<>("tenTinhTrang"));
        quanly_hesonha_col_TinhTrang_ten.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_hesonha_col_TinhTrang_giatri.setCellValueFactory(new PropertyValueFactory<>("hesoTinhTrang"));
        quanly_hesonha_col_NoiThat_giatri.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        quanly_hesonha_col_NgoaiCanh_ten.setCellValueFactory(new PropertyValueFactory<>("ten"));
        quanly_hesonha_col_NgoaiCanh_ten.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_hesonha_col_NgoaiCanh_giatri.setCellValueFactory(new PropertyValueFactory<>("heso"));
        quanly_hesonha_col_NgoaiCanh_giatri.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        for (KetCauDTO ketCauDTO : ketCauBUS.danhsachKetCau()) {
            quanly_hesonha_table_KetCau.getItems().add(ketCauDTO);
        }

        for (NoiThatDTO noiThatDTO : noiThatBUS.danhsachNoiThat()) {
            quanly_hesonha_table_NoiThat.getItems().add(noiThatDTO);
        }

        for (TinhTrangDTO tinhTrangDTO : tinhTrangBUS.danhsachTinhTrang()) {
            quanly_hesonha_table_TinhTrang.getItems().add(tinhTrangDTO);
        }

        for (HeSoNcDTO heSoNcDTO : heSoNcBUS.danhsachNgoaiCanh()) {
            quanly_hesonha_table_NgoaiCanh.getItems().add(heSoNcDTO);
        }
    }

    public void editTenKetCau(TableColumn.CellEditEvent<KetCauDTO, String> editTenKetCau) {
        KetCauDTO ketCauDTO = quanly_hesonha_table_KetCau.getSelectionModel().getSelectedItem();
        ketCauDTO.setTenKetCau(editTenKetCau.getNewValue());
        ketCauDTO.updateTen(new KetCauDAO(), editTenKetCau.getNewValue(), ketCauDTO.getID());
    }
    public void editHeSoKetCau(TableColumn.CellEditEvent<KetCauDTO, Float> editHeSoKetCau) {
        KetCauDTO ketCauDTO = quanly_hesonha_table_KetCau.getSelectionModel().getSelectedItem();
        ketCauDTO.setHesoKetCau(editHeSoKetCau.getNewValue());
        ketCauDTO.updateHeSo(new KetCauDAO(), editHeSoKetCau.getNewValue(), ketCauDTO.getID());
    }
    public void editTenNoiThat(TableColumn.CellEditEvent<NoiThatDTO, String> editTenNoiThat) {
        NoiThatDTO noiThatDTO = quanly_hesonha_table_NoiThat.getSelectionModel().getSelectedItem();
        noiThatDTO.setTenNoiThat(editTenNoiThat.getNewValue());
        noiThatDTO.updateTen(new NoiThatDAO(), editTenNoiThat.getNewValue(), noiThatDTO.getID());
    }
    public void editHeSoNoiThat(TableColumn.CellEditEvent<NoiThatDTO, Float> editHeSoNoiThat) {
        NoiThatDTO noiThatDTO = quanly_hesonha_table_NoiThat.getSelectionModel().getSelectedItem();
        noiThatDTO.setHesoNoiThat(editHeSoNoiThat.getNewValue());
        noiThatDTO.updateHeSo(new NoiThatDAO(), editHeSoNoiThat.getNewValue(), noiThatDTO.getID());
    }
    public void editTenTinhTrang(TableColumn.CellEditEvent<TinhTrangDTO, String> editTenTinhTrang) {
        TinhTrangDTO tinhTrangDTO = quanly_hesonha_table_TinhTrang.getSelectionModel().getSelectedItem();
        tinhTrangDTO.setTenTinhTrang(editTenTinhTrang.getNewValue());
        tinhTrangDTO.updateTen(new TinhTrangDAO(), editTenTinhTrang.getNewValue(), tinhTrangDTO.getID());
    }
    public void editHeSoTinhTrang(TableColumn.CellEditEvent<TinhTrangDTO, Float> editHeSoTinhTrang) {
        TinhTrangDTO tinhTrangDTO = quanly_hesonha_table_TinhTrang.getSelectionModel().getSelectedItem();
        tinhTrangDTO.setHesoTinhTrang(editHeSoTinhTrang.getNewValue());
        tinhTrangDTO.updateHeSo(new TinhTrangDAO(), editHeSoTinhTrang.getNewValue(), tinhTrangDTO.getID());
    }
    public void editTenNgoaiCanh(TableColumn.CellEditEvent<HeSoNcDTO, String> editTenNgoaiCanh) {
        HeSoNcDTO heSoNcDTO = quanly_hesonha_table_NgoaiCanh.getSelectionModel().getSelectedItem();
        heSoNcDTO.setTen(editTenNgoaiCanh.getNewValue());
        heSoNcDTO.updateTen(new HeSoNcDAO(), editTenNgoaiCanh.getNewValue(), heSoNcDTO.getID());
    }
    public void editHeSoNgoaiCanh(TableColumn.CellEditEvent<HeSoNcDTO, Float> editHeSoNgoaiCanh) {
        HeSoNcDTO heSoNcDTO = quanly_hesonha_table_NgoaiCanh.getSelectionModel().getSelectedItem();
        heSoNcDTO.setHeso(editHeSoNgoaiCanh.getNewValue());
        heSoNcDTO.updateHeSo(new HeSoNcDAO(), editHeSoNgoaiCanh.getNewValue(), heSoNcDTO.getID());
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

    // nút chức năng thêm xóa sửa
    public void switchToThemNha(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/themheso.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void xoaHeSo(ActionEvent event) {
        KetCauDTO ketCauDTO = quanly_hesonha_table_KetCau.getSelectionModel().getSelectedItem();
        quanly_hesonha_table_KetCau.getItems().remove(ketCauDTO);
        if (ketCauDTO != null) {
            ketCauDTO.xoaKetCau(new KetCauDAO(), ketCauDTO.getID());
        }

        NoiThatDTO noiThatDTO = quanly_hesonha_table_NoiThat.getSelectionModel().getSelectedItem();
        quanly_hesonha_table_NoiThat.getItems().remove(noiThatDTO);
        if (noiThatDTO != null) {
            noiThatDTO.xoaNoiThat(new NoiThatDAO(), noiThatDTO.getID());

        }

        TinhTrangDTO tinhTrangDTO = quanly_hesonha_table_TinhTrang.getSelectionModel().getSelectedItem();
        quanly_hesonha_table_TinhTrang.getItems().remove(tinhTrangDTO);
        if (tinhTrangDTO != null) {
            tinhTrangDTO.xoaTinhTrang(new TinhTrangDAO(), tinhTrangDTO.getID());
        }

        HeSoNcDTO heSoNcDTO = quanly_hesonha_table_NgoaiCanh.getSelectionModel().getSelectedItem();
        quanly_hesonha_table_NgoaiCanh.getItems().remove(heSoNcDTO);
        if (heSoNcDTO != null) {
            heSoNcDTO.xoaNgoaiCanh(new HeSoNcDAO(), heSoNcDTO.getID());
        }
        quanly_hesonha_table_KetCau.getSelectionModel().clearSelection();
        quanly_hesonha_table_NgoaiCanh.getSelectionModel().clearSelection();
        quanly_hesonha_table_TinhTrang.getSelectionModel().clearSelection();
        quanly_hesonha_table_NoiThat.getSelectionModel().clearSelection();
    }

    public void clearHeSo(ActionEvent event) {
        quanly_hesonha_table_TinhTrang.getSelectionModel().clearSelection();
        quanly_hesonha_table_NoiThat.getSelectionModel().clearSelection();
        quanly_hesonha_table_KetCau.getSelectionModel().clearSelection();
        quanly_hesonha_table_NgoaiCanh.getSelectionModel().clearSelection();
    }
}

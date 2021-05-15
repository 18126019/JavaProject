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
import src.BUS.heSo.hesoDat.HemBUS;
import src.BUS.heSo.hesoDat.HinhDangBUS;
import src.BUS.heSo.hesoDat.KhuDanCuBUS;
import src.BUS.heSo.hesoDat.MatTienBUS;
import src.DAO.heSo.hesoDat.HemDAO;
import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.DAO.heSo.hesoDat.KhuDanCuDAO;
import src.DAO.heSo.hesoDat.MatTienDAO;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.heSo.hesoDat.HemDTO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.DTO.heSo.hesoDat.KhuDanCuDTO;
import src.DTO.heSo.hesoDat.MatTienDTO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.application.java.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerQuanlyHeSoDat implements Initializable {
    @FXML
    private JFXButton quanly_btn_nguoidung;
    @FXML
    private JFXButton quanly_btn_nhadat;
    @FXML
    private JFXButton quanly_btn_hesodat;
    @FXML
    private JFXButton quanly_btn_hesonha;

    @FXML
    private TableView<HemDTO> quanly_hesodat_table_Hem;
    @FXML
    private TableColumn quanly_hesodat_col_Hem_ten;
    @FXML
    private TableColumn<HemDTO, Float> quanly_hesodat_col_Hem_giatri;
    private HemBUS hemBUS = new HemBUS();

    @FXML
    private TableView<HinhDangDTO> quanly_hesodat_table_HinhDang;
    @FXML
    private TableColumn quanly_hesodat_col_HinhDang_ten;
    @FXML
    private TableColumn<HinhDangDTO, Float> quanly_hesodat_col_HinhDang_giatri;
    private HinhDangBUS hinhDangBUS = new HinhDangBUS();

    @FXML
    private TableView<KhuDanCuDTO> quanly_hesodat_table_KDC;
    @FXML
    private TableColumn quanly_hesodat_col_KDC_ten;
    @FXML
    private TableColumn<KhuDanCuDTO, Float> quanly_hesodat_col_KDC_giatri;
    private KhuDanCuBUS khuDanCuBUS = new KhuDanCuBUS();

    @FXML
    private TableView<MatTienDTO> quanly_hesodat_table_MatTien;
    @FXML
    private TableColumn quanly_hesodat_col_MatTien_ten;
    @FXML
    private TableColumn<MatTienDTO, Float> quanly_hesodat_col_MatTien_giatri;
    private MatTienBUS matTienBUS = new MatTienBUS();

    @FXML
    private JFXButton quanly_heso_btn_xoa;
    @FXML
    private JFXButton quanly_heso_btn_them;
    @FXML
    private JFXButton quanly_heso_btn_clear;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quanly_hesodat_table_Hem.setEditable(true);
        quanly_hesodat_table_HinhDang.setEditable(true);
        quanly_hesodat_table_KDC.setEditable(true);
        quanly_hesodat_table_KDC.setEditable(true);

        quanly_hesodat_col_Hem_ten.setCellValueFactory(new PropertyValueFactory<>("tenHem"));
        quanly_hesodat_col_Hem_ten.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_hesodat_col_Hem_giatri.setCellValueFactory(new PropertyValueFactory<>("hesoHem"));
        quanly_hesodat_col_Hem_giatri.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        quanly_hesodat_col_HinhDang_ten.setCellValueFactory(new PropertyValueFactory<>("tenHinhDang"));
        quanly_hesodat_col_HinhDang_ten.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_hesodat_col_HinhDang_giatri.setCellValueFactory(new PropertyValueFactory<>("hesoHinhDang"));
        quanly_hesodat_col_HinhDang_giatri.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        quanly_hesodat_col_KDC_ten.setCellValueFactory(new PropertyValueFactory<>("tenKhuDanCu"));
        quanly_hesodat_col_KDC_ten.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_hesodat_col_KDC_giatri.setCellValueFactory(new PropertyValueFactory<>("hesoKhuDanCu"));
        quanly_hesodat_col_KDC_giatri.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        quanly_hesodat_col_MatTien_ten.setCellValueFactory(new PropertyValueFactory<>("tenMatTien"));
        quanly_hesodat_col_MatTien_ten.setCellFactory(TextFieldTableCell.forTableColumn());
        quanly_hesodat_col_MatTien_giatri.setCellValueFactory(new PropertyValueFactory<>("hesoMatTien"));
        quanly_hesodat_col_MatTien_giatri.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));

        for (HemDTO hemDTO : hemBUS.danhsachHem()) {
            quanly_hesodat_table_Hem.getItems().add(hemDTO);
        }

        for (HinhDangDTO hinhDangDTO : hinhDangBUS.danhsachHinhDang()) {
            quanly_hesodat_table_HinhDang.getItems().add(hinhDangDTO);
        }

        for (KhuDanCuDTO khuDanCuDTO : khuDanCuBUS.danhsachKhuDanCu()) {
            quanly_hesodat_table_KDC.getItems().add(khuDanCuDTO);
        }

        for (MatTienDTO matTienDTO : matTienBUS.danhsachMatTien()) {
            quanly_hesodat_table_MatTien.getItems().add(matTienDTO);
        }

    }

    public void editTenHem(TableColumn.CellEditEvent<HemDTO, String> editTenHem) {
        HemDTO hemDTO = quanly_hesodat_table_Hem.getSelectionModel().getSelectedItem();
        hemDTO.setTenHem(editTenHem.getNewValue());
        hemDTO.updateTen(new HemDAO(), editTenHem.getNewValue(), hemDTO.getID());
    }
    public void editHeSoHem(TableColumn.CellEditEvent<HemDTO, Float> editTenHem) {
        HemDTO hemDTO = quanly_hesodat_table_Hem.getSelectionModel().getSelectedItem();
        hemDTO.setHesoHem(editTenHem.getNewValue());
        hemDTO.updateHeSo(new HemDAO(), editTenHem.getNewValue(), hemDTO.getID());
    }

    public void editTenHinhDang(TableColumn.CellEditEvent<HinhDangDTO, String> editTenHinhDang) {
        HinhDangDTO hinhDangDTO = quanly_hesodat_table_HinhDang.getSelectionModel().getSelectedItem();
        hinhDangDTO.setTenHinhDang(editTenHinhDang.getNewValue());
        hinhDangDTO.updateTen(new HinhDangDAO(), editTenHinhDang.getNewValue(), hinhDangDTO.getId());
    }
    public void editHeSoHinhDang(TableColumn.CellEditEvent<HinhDangDTO, Float> editTenHinhDang) {
        HinhDangDTO hinhDangDTO = quanly_hesodat_table_HinhDang.getSelectionModel().getSelectedItem();
        hinhDangDTO.setHesoHinhDang(editTenHinhDang.getNewValue());
        hinhDangDTO.updateHeSo(new HinhDangDAO(), editTenHinhDang.getNewValue(), hinhDangDTO.getId());
    }

    public void editTenKDC(TableColumn.CellEditEvent< KhuDanCuDTO, String> editTenKDC) {
        KhuDanCuDTO khuDanCuDTO = quanly_hesodat_table_KDC.getSelectionModel().getSelectedItem();
        khuDanCuDTO.setTenKhuDanCu(editTenKDC.getNewValue());
        khuDanCuDTO.updateTen(new KhuDanCuDAO(), editTenKDC.getNewValue(), khuDanCuDTO.getId());
    }
    public void editHeSoKDC(TableColumn.CellEditEvent<HinhDangDTO, Float> editTenHinhDang) {
        HinhDangDTO hinhDangDTO = quanly_hesodat_table_HinhDang.getSelectionModel().getSelectedItem();
        hinhDangDTO.setHesoHinhDang(editTenHinhDang.getNewValue());
        hinhDangDTO.updateHeSo(new HinhDangDAO(), editTenHinhDang.getNewValue(), hinhDangDTO.getId());
    }

    public void editTenMatTien(TableColumn.CellEditEvent<HemDTO, String> editTenMatTien) {
        HemDTO hemDTO = quanly_hesodat_table_Hem.getSelectionModel().getSelectedItem();
        hemDTO.setTenHem(editTenMatTien.getNewValue());
        hemDTO.updateTen(new HemDAO(), editTenMatTien.getNewValue(), hemDTO.getID());
    }
    public void editHeSoMatTien(TableColumn.CellEditEvent<HemDTO, Float> editTenMatTien) {
        MatTienDTO matTienDTO = quanly_hesodat_table_MatTien.getSelectionModel().getSelectedItem();
        matTienDTO.setHesoMatTien(editTenMatTien.getNewValue());
        matTienDTO.updateHeSo(new MatTienDAO(), editTenMatTien.getNewValue(),matTienDTO.getId());
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
        public void switchToHeSoNha(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/quanlyhesonha.fxml"));
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

        HemDTO hemDTO = quanly_hesodat_table_Hem.getSelectionModel().getSelectedItem();
        quanly_hesodat_table_Hem.getItems().remove(hemDTO);
        if (hemDTO != null) {
            hemDTO.xoaHem(new HemDAO(), hemDTO.getID());
        }
        HinhDangDTO hinhDangDTO = quanly_hesodat_table_HinhDang.getSelectionModel().getSelectedItem();
        quanly_hesodat_table_HinhDang.getItems().remove(hinhDangDTO);
        if (hinhDangDTO != null) {
            hinhDangDTO.xoaHinhDang(new HinhDangDAO(), hinhDangDTO.getId());

        }
        KhuDanCuDTO khuDanCuDTO = quanly_hesodat_table_KDC.getSelectionModel().getSelectedItem();
        quanly_hesodat_table_KDC.getItems().remove(khuDanCuDTO);
        if (khuDanCuDTO != null) {
            khuDanCuDTO.xoaKhuDanCu(new KhuDanCuDAO(), khuDanCuDTO.getId());
        }
        MatTienDTO matTienDTO = quanly_hesodat_table_MatTien.getSelectionModel().getSelectedItem();
        quanly_hesodat_table_MatTien.getItems().remove(matTienDTO);
        if (matTienDTO != null) {
            matTienDTO.xoaMatTien(new MatTienDAO(), matTienDTO.getId());
        }


        quanly_hesodat_table_HinhDang.getSelectionModel().clearSelection();
        quanly_hesodat_table_Hem.getSelectionModel().clearSelection();
        quanly_hesodat_table_KDC.getSelectionModel().clearSelection();
        quanly_hesodat_table_MatTien.getSelectionModel().clearSelection();
    }

    public void clearHeSo(ActionEvent event) {
        quanly_hesodat_table_HinhDang.getSelectionModel().clearSelection();
        quanly_hesodat_table_Hem.getSelectionModel().clearSelection();
        quanly_hesodat_table_KDC.getSelectionModel().clearSelection();
        quanly_hesodat_table_MatTien.getSelectionModel().clearSelection();
    }
}

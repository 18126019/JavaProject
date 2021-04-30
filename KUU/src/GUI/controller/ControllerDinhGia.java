package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import src.BUS.heSo.hesoDat.HemBUS;
import src.BUS.heSo.hesoDat.HinhDangBUS;
import src.BUS.heSo.hesoDat.KhuDanCuBUS;
import src.BUS.heSo.hesoDat.MatTienBUS;
import src.DTO.heSo.hesoDat.HemDTO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.DTO.heSo.hesoDat.KhuDanCuDTO;
import src.DTO.heSo.hesoDat.MatTienDTO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerDinhGia implements Initializable {

    @FXML
    private JFXComboBox dinhgia_quan;
    @FXML
    private JFXComboBox dinhgia_duong;
    @FXML
    private JFXComboBox dinhgia_sotang;
    @FXML
    private JFXComboBox dinhgia_dientich;
    @FXML
    private JFXComboBox dinhgia_hem;
    @FXML
    private JFXComboBox dinhgia_hinhdang;
    @FXML
    private JFXComboBox dinhgia_khudancu;
    @FXML
    private JFXComboBox dinhgia_mattien;
    @FXML
    private JFXComboBox dinhgia_ketcau;
    @FXML
    private JFXComboBox dinhgia_noithat;
    @FXML
    private JFXComboBox dinhgia_tinhtrang;
    @FXML
    private JFXComboBox dinhgia_ngoaicanh;
    @FXML
    private JFXButton dinhgia_btn_xacnhan;
    @FXML
    private JFXTextField dinhgia_txt_giatien;

    public void dsHem() {
        HemBUS hemBUS = new HemBUS();
        ArrayList<HemDTO> listHem = hemBUS.danhsachHem();
        for (HemDTO h : listHem) {
            dinhgia_hem.getItems().add(h.getTenHem());
        }
    }
    public void dsHinhDang() {
        HinhDangBUS hinhDangBUS = new HinhDangBUS();
        ArrayList<HinhDangDTO> listHinhDang = hinhDangBUS.danhsachHinhDang();
        for (HinhDangDTO h : listHinhDang) {
            dinhgia_hinhdang.getItems().add(h.getTenHinhDang());
        }
    }
    public void dsKhuDanCu() {
        KhuDanCuBUS khuDanCuBUS = new KhuDanCuBUS();
        ArrayList<KhuDanCuDTO> listHinhDang = khuDanCuBUS.danhsachKhuDanCu();
        for (KhuDanCuDTO h : listHinhDang) {
            dinhgia_khudancu.getItems().add(h.getTenKhuDanCu());
        }
    }
    public void dsMatTien() {
        MatTienBUS matTienBUS = new MatTienBUS();
        ArrayList<MatTienDTO> listMatTien = matTienBUS.danhsachMatTien();
        for (MatTienDTO h : listMatTien) {
            dinhgia_mattien.getItems().add(h.getTenMatTien());
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dsHem();
        dsHinhDang();
        dsKhuDanCu();
        dsMatTien();

    }
}

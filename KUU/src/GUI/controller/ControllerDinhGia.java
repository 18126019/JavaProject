package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import src.BUS.heSo.DonGiaNnBUS;
import src.BUS.heSo.HeSoNcBUS;
import src.BUS.heSo.hesoDat.HemBUS;
import src.BUS.heSo.hesoDat.HinhDangBUS;
import src.BUS.heSo.hesoDat.KhuDanCuBUS;
import src.BUS.heSo.hesoDat.MatTienBUS;
import src.BUS.heSo.hesoNha.KetCauBUS;
import src.BUS.heSo.hesoNha.NoiThatBUS;
import src.BUS.heSo.hesoNha.TinhTrangBUS;
import src.DTO.heSo.DonGiaNnDTO;
import src.DTO.heSo.HeSoNcDTO;
import src.DTO.heSo.hesoDat.HemDTO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.DTO.heSo.hesoDat.KhuDanCuDTO;
import src.DTO.heSo.hesoDat.MatTienDTO;
import src.DTO.heSo.hesoNha.KetCauDTO;
import src.DTO.heSo.hesoNha.NoiThatDTO;
import src.DTO.heSo.hesoNha.TinhTrangDTO;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerDinhGia implements Initializable {

    @FXML
    private JFXComboBox dinhgia_quan;
    @FXML
    private JFXComboBox dinhgia_duong;
    @FXML
    private JFXTextField dinhgia_txt_sotang;
    @FXML
    private JFXTextField dinhgia_txt_dientich;
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


    HemBUS hemBUS = new HemBUS();
    HinhDangBUS hinhDangBUS = new HinhDangBUS();
    KhuDanCuBUS khuDanCuBUS = new KhuDanCuBUS();
    MatTienBUS matTienBUS = new MatTienBUS();
    KetCauBUS ketCauBUS = new KetCauBUS();
    NoiThatBUS noiThatBUS = new NoiThatBUS();
    TinhTrangBUS tinhTrangBUS = new TinhTrangBUS();
    HeSoNcBUS heSoNcBUS = new HeSoNcBUS();
    DonGiaNnBUS donGiaNnBUS = new DonGiaNnBUS();

    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            String hem = dinhgia_hem.getValue().toString();
            String hinhdang = dinhgia_hinhdang.getValue().toString();
            String khudancu = dinhgia_khudancu.getValue().toString();
            String mattien = dinhgia_mattien.getValue().toString();
            String ketcau = dinhgia_ketcau.getValue().toString();
            String noithat = dinhgia_noithat.getValue().toString();
            String tinhtrang = dinhgia_tinhtrang.getValue().toString();
            String ngoaicanh = dinhgia_ngoaicanh.getValue().toString();
            float hesoHem = 0;
            float hesoHinhDang = 0;
            float hesoKhuDanCu = 0;
            float hesoMatTien = 0;
            float hesoKetCau = 0;
            float hesoNoiThat = 0;
            float hesoTinhTrang = 0;
            float hesoNgoaiCanh = 0;
            float dongiaNn = 0;

            float giaDat = 0;
            float giaNha = 0;

            for (HemDTO h : hemBUS.danhsachHem()) {
                if (hem.equals(h.getTenHem())) {
                    hesoHem = h.getHesoHem();
                    break;
                }
            }
            for (HinhDangDTO h : hinhDangBUS.danhsachHinhDang()) {
                if (hinhdang.equals(h.getTenHinhDang())) {
                    hesoHinhDang = h.getHesoHinhDang();
                    break;
                }
            }
            for (KhuDanCuDTO h : khuDanCuBUS.danhsachKhuDanCu()) {
                if (khudancu.equals(h.getTenKhuDanCu())) {
                    hesoKhuDanCu = h.getHesoKhuDanCu();
                    break;
                }
            }
            for (MatTienDTO h : matTienBUS.danhsachMatTien()) {
                if (mattien.equals(h.getTenMatTien())) {
                    hesoMatTien = h.getHesoMatTien();
                    break;
                }
            }
            for (KetCauDTO h : ketCauBUS.danhsachKetCau()) {
                if (ketcau.equals(h.getTenKetCau())) {
                    hesoKetCau = h.getHesoKetCau();
                    break;
                }
            }
            for (NoiThatDTO h : noiThatBUS.danhsachNoiThat()) {
                if (noithat.equals(h.getTenNoiThat())) {
                    hesoKhuDanCu = h.getHesoNoiThat();
                    break;
                }
            }
            for (TinhTrangDTO h : tinhTrangBUS.danhsachTinhTrang()) {
                if (tinhtrang.equals(h.getTenTinhTrang())) {
                    hesoTinhTrang = h.getHesoTinhTrang();
                    break;
                }
            }
            for (HeSoNcDTO h : heSoNcBUS.danhsachNgoaiCanh()) {
                if (ngoaicanh.equals(h.getTen())) {
                    hesoNgoaiCanh = h.getHeso();
                    break;
                }
            }
            for (DonGiaNnDTO h : donGiaNnBUS.danhsachDonGiaNn()) {
                if (dinhgia_quan.getValue().toString().equals(h.getQuan())
                 || dinhgia_duong.getValue().toString().equals(h.getDuong())) {
                    dongiaNn = h.getGiaTien();
                    break;
                }
            }
            float sotang = Float.parseFloat(dinhgia_txt_sotang.getText());
            float dientich = Float.parseFloat(dinhgia_txt_dientich.getText());

            giaDat = dientich * dongiaNn * hesoHem * hesoHinhDang * hesoKhuDanCu * hesoMatTien;
            giaNha = dientich * sotang * hesoKetCau * hesoNoiThat * hesoTinhTrang;
            float dinhGia = (giaDat + giaNha) * hesoNgoaiCanh;

            if ( dongiaNn != 0) {
                dinhgia_txt_giatien.setText(String.valueOf(dinhGia));
            }
            else {
                dinhgia_txt_giatien.setText("Không tìm thấy vị trí nhà, vui lòng nhập lại");
            }
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Bắt đầu thêm dữ liệu vào các combobox
        for (HemDTO h : hemBUS.danhsachHem()) {
            dinhgia_hem.getItems().add(h.getTenHem());
        }
        for (HinhDangDTO h : hinhDangBUS.danhsachHinhDang()) {
            dinhgia_hinhdang.getItems().add(h.getTenHinhDang());
        }
        for (KhuDanCuDTO h : khuDanCuBUS.danhsachKhuDanCu()) {
            dinhgia_khudancu.getItems().add(h.getTenKhuDanCu());
        }
        for (MatTienDTO h : matTienBUS.danhsachMatTien()) {
            dinhgia_mattien.getItems().add(h.getTenMatTien());
        }
        for (KetCauDTO h : ketCauBUS.danhsachKetCau()) {
            dinhgia_ketcau.getItems().add(h.getTenKetCau());
        }
        for (NoiThatDTO h : noiThatBUS.danhsachNoiThat()) {
            dinhgia_noithat.getItems().add(h.getTenNoiThat());
        }
        for (TinhTrangDTO h : tinhTrangBUS.danhsachTinhTrang()) {
            dinhgia_tinhtrang.getItems().add(h.getTenTinhTrang());
        }
        for (HeSoNcDTO h : heSoNcBUS.danhsachNgoaiCanh()) {
            dinhgia_ngoaicanh.getItems().add(h.getTen());
        }
        // Kết thúc thêm dữ liệu


        dinhgia_txt_giatien.setDisable(true);
        dinhgia_btn_xacnhan.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);


    }
}

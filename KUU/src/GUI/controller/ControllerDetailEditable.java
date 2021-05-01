package src.GUI.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.nha.DangBanNhaDTO;


public class ControllerDetailEditable {
    private DangBanNhaDTO nha;
    @FXML
    private ImageView img;

    @FXML
    private JFXTextField tbChuNha;

    @FXML
    private JFXTextField tbSdt;

    @FXML
    private JFXTextField tbDienTich;

    @FXML
    private JFXTextField tbSoTang;

    @FXML
    private JFXTextField tbKetCau;

    @FXML
    private JFXTextField tbSoNha;

    @FXML
    private JFXTextField tbDuong;

    @FXML
    private JFXTextField tbPhuong;

    @FXML
    private JFXTextField tbQuan;

    @FXML
    private JFXTextField tbGiaTien;

    @FXML
    private JFXTextArea tbGhiChu;

    @FXML
    private JFXButton btnLuu;

    @FXML
    private JFXButton btnHuy;

    public void saveModifiedHome() {
        nha.setDienTich(Float.parseFloat(tbDienTich.getText()));
        nha.setSoTang(Float.parseFloat(tbSoTang.getText()));
        nha.setKetcau(tbKetCau.getText());
        nha.setDuong(tbDuong.getText());
        nha.setPhuong(tbPhuong.getText());
        nha.setQuan(tbQuan.getText());
        nha.setGiaTien(Float.parseFloat(tbGiaTien.getText()));
        nha.setGhichu(tbGhiChu.getText());

        KhachHangDAO kh = new KhachHangDAO();
        kh.suaNha(nha);
    }

}

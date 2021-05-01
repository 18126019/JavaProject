package src.GUI.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.nha.DangBanNhaDTO;

public class ControllerThemNha {

    @FXML
    private ImageView img;

    @FXML
    private JFXTextField tbDienTich;

    @FXML
    private JFXTextField tbSoTang;

    @FXML
    private JFXTextField tbGiaTien;

    @FXML
    private JFXTextField tbSoNha;

    @FXML
    private JFXTextField tbDuong;

    @FXML
    private JFXTextField tbPhuong;

    @FXML
    private JFXTextField tbQuan;

    @FXML
    private JFXTextField tbKetCau;

    @FXML
    private JFXTextArea tbGhiChu;

    public void addHome() {
        KhachHangDAO kh = new KhachHangDAO();
        DangBanNhaDTO nha = new DangBanNhaDTO();
        kh.themNha(nha);
    }
}

package src.GUI.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.nha.DangBanNhaDTO;

import java.io.File;
import java.io.IOException;

public class ControllerThemNha {
    private String url;
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

    public void chooseImage(ActionEvent e) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose a image");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fc.getExtensionFilters().add(imageFilter);

        File file = fc.showOpenDialog(null);
        if (file != null){
            Image image = new Image(file.toURI().toString(),320, 213, false, true);
            this.url = file.toURI().toString();
            img.setImage(image);
        }
    }
    public void addHome() {
        KhachHangDAO kh = new KhachHangDAO();
        DangBanNhaDTO nha = new DangBanNhaDTO();

        nha.setDienTich(Float.parseFloat(tbDienTich.getText()));
        nha.setSoTang(Float.parseFloat(tbSoTang.getText()));
        nha.setKetcau(tbKetCau.getText());
        nha.setSoNha(tbSoNha.getText());
        nha.setDuong(tbDuong.getText());
        nha.setPhuong(tbPhuong.getText());
        nha.setQuan(tbQuan.getText());
        nha.setGiaTien(Float.parseFloat(tbGiaTien.getText()));
        nha.setGhichu(tbGhiChu.getText());
        nha.setImgUrl(this.url);

        kh.themNha(nha);
    }
}

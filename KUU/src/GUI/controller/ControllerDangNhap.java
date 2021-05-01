package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import src.BUS.nguoiDung.KhachHangBUS;
import src.BUS.nguoiDung.NguoiDung;
import src.BUS.nguoiDung.QuanTriBUS;
import src.DTO.nguoiDung.KhachHangDTO;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerDangNhap implements Initializable {
	@FXML
	private JFXTextField tendn;
	@FXML
	private JFXPasswordField matkhau;
	@FXML
	private JFXButton btndn;
	@FXML
	private JFXButton chuyendk;


	public void Login(){
		btndn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				KhachHangBUS khachHangBUS = new KhachHangBUS();
				ArrayList<KhachHangDTO> ds = khachHangBUS.danhSachKhachHang();
				boolean flat = false;
				for(int i = 0; i < ds.size(); i++)
				{
					if (tendn.getText().equals(ds.get(i).getTenDangNhap()) && matkhau.getText().equals(ds.get(i).getMatKhau())){
						flat = true;
					}
				}
				if (flat == true) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("Ban dang nhap thanh cong");
					alert.show();
				} else {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("Ban dang nhap khong thanh cong");
					alert.show();
				}
			}
		});
	}

	public void Chuyendk(){
		chuyendk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event){
				Parent root = null;
				try {
					root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/dangky.fxml"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(root);

				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			}

		});
	}
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		Login(); // dang nhap
		Chuyendk(); // chuyen qua man hinh dang ky
	}


}

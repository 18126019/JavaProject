package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import src.BUS.nguoiDung.KhachHangBUS;
import src.DTO.nguoiDung.KhachHangDTO;
import src.application.java.UserSession;

import java.io.IOException;
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

	public void Login() {
		btndn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				KhachHangBUS khachHangBUS = new KhachHangBUS();
				ArrayList<KhachHangDTO> ds = khachHangBUS.danhSachKhachHang();
				boolean flat = false;
				for (int i = 0; i < ds.size(); i++) {
					if (tendn.getText().equals(ds.get(i).getTenDangNhap()) && matkhau.getText().equals(ds.get(i).getMatKhau())) {
						flat = true;
						UserSession userSession = UserSession.getInstace(ds.get(i).getTenDangNhap());
						try {
							switchToHome(event);
						} catch (IOException e) {
							e.printStackTrace();
						}
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

	public void Chuyendk() {
		chuyendk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Parent root = null;
				try {
					root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/dangky.fxml"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(root);

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

	public void switchToHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/home.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
	public void switchToSetting(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/setting.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	public void switchToDinhGia(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/dinhgia.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	public void switchToSearch(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/timkiem.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	public void switchToAddHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/themNha.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

}

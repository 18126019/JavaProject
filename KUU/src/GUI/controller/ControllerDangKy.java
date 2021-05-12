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
import src.BUS.nguoiDung.NguoiDung;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DAO.nguoiDung.QuanTriDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDangKy implements Initializable {
	@FXML
	private JFXTextField hoten;
	@FXML
	private JFXTextField tendn;
	@FXML
	private JFXTextField matkhau;
	@FXML
	private JFXTextField rematkhau;
	@FXML
	private JFXTextField sdt;
	@FXML
	private JFXTextField email;
	@FXML
	private JFXButton dangky_btn_dangky;
	@FXML
	private JFXButton dangky_btn_huy;
	@FXML
	private JFXButton chuyendn;

	public void NhapttNguoiD() {
		dangky_btn_dangky.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				QuanTriDAO quanTriDAO = new QuanTriDAO();
				KhachHangDAO khachHangDAO = new KhachHangDAO();
				if(tendn.getText() != "" && hoten.getText() != " " && email.getText() != " " && sdt.getText() != " ") {
					if (rematkhau.getText().equals(matkhau.getText()) && matkhau.getText() != " "  && rematkhau.getText() != " ") {
						khachHangDAO.setMatKhau(matkhau.getText());
						khachHangDAO.setHoTen(hoten.getText());
						khachHangDAO.setTenDangNhap(tendn.getText());
						khachHangDAO.setEmail(email.getText());
						khachHangDAO.setSdt(sdt.getText());

						quanTriDAO.themKhachHang(khachHangDAO);

						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setContentText("Ban dang ky thanh cong");
						alert.show();
						try {
							switchToAccount(event);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						Alert alert = new Alert(Alert.AlertType.WARNING);
						alert.setContentText("Mat khau cua ban chua khop");
						alert.show();
					}
				}else {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setContentText("Ban chua nhap du thong tin");
					alert.show();
				}
			}
		});
	}

	public void Huy(){
		dangky_btn_huy.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				hoten.clear();
				tendn.clear();
				matkhau.clear();
				rematkhau.clear();
				sdt.clear();
				email.clear();
			}
		});

	}
	public void Chuyendn(){
		chuyendn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event){
				Parent root = null;
				try {
					root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/login.fxml"));
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
		Chuyendn(); // chuyen qua man hinh dang nhap
		NhapttNguoiD(); // nhap thong tin nguoi moi dang ky
		Huy(); // huy tat ca tt
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
	public void switchToAccount(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/login.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}

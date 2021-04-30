package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CotrollerCDChung implements Initializable{
	@FXML
	private JFXComboBox<String> cbngonngu ;
	@FXML
	private JFXToggleButton capnhap;
	@FXML
	private JFXButton btncaidatc;
	@FXML
	private JFXButton btngioithieu;

	public void setNgonNgu(){
		cbngonngu.getItems().add("Tieng Viet");
		cbngonngu.getItems().add("Tieng Anh");
	}

	public void setCapnhap(){
		capnhap.setDisable(true);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		setCapnhap();
		setNgonNgu();

	}

}

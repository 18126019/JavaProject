package src.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CotrollerCDChung implements Initializable{
	@FXML
	private JFXComboBox<String> cbngonngu ;
	@FXML
	private JFXToggleButton capnhap;
	@FXML
	private JFXButton btngioithieu;

	public void setNgonNgu(){
		cbngonngu.getItems().add("Tieng Viet");
	//	cbngonngu.getItems().add("Tieng Anh");

	}

	public void setCapnhap(){
		capnhap.setDisable(true);
	}

	public void switchGT() {
		btngioithieu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Parent root = null;
				try {
					root = FXMLLoader.load(getClass().getResource("../resources/fxml/introduction.fxml"));
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
		setCapnhap(); // cap nhap neu co
		setNgonNgu(); // chinh ngon ngu
		switchGT(); //chuyen qua gioi thieu

	}

}

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

public class ControllerGioiThieu implements Initializable {
	@FXML
	private JFXButton btnquyenrt;
	@FXML
	private JFXButton btndksd;
	@FXML
	private JFXButton btncaidatc;
	@FXML
	private JFXButton btngioithieu;


	public void showQRT() {
		btnquyenrt.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e)
			{
				try {
					FXMLLoader fXMLLoader = new FXMLLoader();
					fXMLLoader.setLocation(getClass().getResource("../resources/fxml/ppopup.fxml"));
					Parent root = fXMLLoader.load();
					Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		});
	}


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		showQRT();
	}


}

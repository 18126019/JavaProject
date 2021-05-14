package src.GUI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.application.java.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGioiThieu implements Initializable {

	public void showQRT(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/quyenrt.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	public void showDKSD(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/dksdung.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}

	public void switchCD(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/setting.fxml"));
		Scene scene = new Scene(root);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void switchToHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/home.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		System.out.println(UserSession.getInstance("a").toString());
	}

	public void switchToDetail(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/detailHome.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}


	public void switchToDetailEditable(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/detailEditable.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	public void switchToAccount(ActionEvent event) throws IOException {
		String name = UserSession.getInstance("a").getUserName();
		System.out.println(name);
		if(!name.equals("a")) {
			Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/thongtintaikhoan.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
		else {
			UserSession.clearUserSession();
			Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/login.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
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
		String name = UserSession.getInstance("a").getUserName();
		System.out.println(name);
		if(!name.equals("a")) {
			Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/themNha.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
		else {
			UserSession.clearUserSession();
			Parent root = FXMLLoader.load(getClass().getResource("../../GUI/resources/fxml/login.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

	}
}


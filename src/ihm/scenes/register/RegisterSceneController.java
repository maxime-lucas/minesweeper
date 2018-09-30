package ihm.scenes.register;

import data.controllers.PlayerManager;
import data.interfaces.iPlayerManager;
import data.models.Player;
import exceptions.LoginAlreadyExistsException;
import ihm.MainClass;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegisterSceneController {

	private MainClass main;
	private iPlayerManager playerManager = new PlayerManager();
	
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private TextField login;
	@FXML
	private PasswordField password;
	@FXML
	private PasswordField confirmPassword;
	
	public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
    }
	
	public void doClickLogin() {
		main.initLoginScene();
	}
	
	public void doClickRegister() {

		String firstnameValue = firstname.getText();
		String lastnameValue = lastname.getText();
		String loginValue = login.getText();
		String passwordValue = password.getText();
		String confirmPasswordValue = confirmPassword.getText();
		
		if( !passwordValue.equals(confirmPasswordValue) ) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Passwords mismatch");
			alert.setHeaderText("Passwords mismatch");
			alert.setContentText("The password and the confirm password should be equal !");

			alert.showAndWait();
			return;
		}
		
		Player newPlayer = new Player();
		newPlayer.setFirstname(firstnameValue);
		newPlayer.setLastname(lastnameValue);
		newPlayer.setLogin(loginValue);
		newPlayer.setPassword(passwordValue);
		
		try {
			playerManager.register(newPlayer);
			main.initMenuScene();
		} catch (LoginAlreadyExistsException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Login already taken");
			alert.setHeaderText("Login already taken");
			alert.setContentText("This login is already used. Please take another one !");

			alert.showAndWait();
		}
	}
	
}

package ihm.views;

import data.MissingCredentialsException;
import data.controllers.PlayerManager;
import data.interfaces.iPlayerManager;
import ihm.MainClass;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginSceneController {
	
	private MainClass main;
	@FXML
	private TextField login;
	@FXML
	private PasswordField password;
	
	private iPlayerManager playerManager;
    
	public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
    }
	
	public void doClickLogin() {
		String loginValue = login.getText();
		String passwordValue = password.getText();
		
		playerManager = new PlayerManager();
		
		try {
			playerManager.login(loginValue, passwordValue);
		} catch (MissingCredentialsException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Missing Credentials");
			alert.setContentText("The fields 'login' and 'password' are mandatory !");

			alert.showAndWait();
		}
	}
}

package ihm.scenes.login;

import data.controllers.PlayerManager;
import data.interfaces.iPlayerManager;
import exceptions.MissingCredentialsException;
import ihm.MainClass;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginSceneController {
	
	private MainClass main;
	private iPlayerManager playerManager = new PlayerManager();
	
	@FXML
	private TextField login;
	@FXML
	private PasswordField password;
    
	public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
    }
	
	public void doClickLogin() {
		String loginValue = login.getText();
		String passwordValue = password.getText();
		
		try {
			
			playerManager.login(loginValue, passwordValue);
			main.initMenuScene();
			
		} catch (MissingCredentialsException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Missing Credentials");
			alert.setHeaderText("Missing Credentials");
			alert.setContentText("The fields 'login' and 'password' are mandatory !");

			alert.showAndWait();
		}
	}
	
	public void doClickRegister() {
		main.initRegisterScene();
	}
}

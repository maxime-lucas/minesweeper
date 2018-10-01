package ihm.scenes.noExistingProfile;

import data.controllers.PlayerManager;
import data.interfaces.iPlayerManager;
import ihm.MainClass;

public class NoExistingProfileSceneController {
	private MainClass main;
	private iPlayerManager playerManager = new PlayerManager();
	
	public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
    }
	
	public void doClickNo() {
		playerManager.cancelProfileCreation();
		main.initLoginScene();
	}
	
	public void doClickYes() {
		main.initCreateProfileScene();
	}
	
}

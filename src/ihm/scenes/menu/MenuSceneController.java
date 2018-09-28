package ihm.scenes.menu;

import data.controllers.PlayerManager;
import data.interfaces.iPlayerManager;
import ihm.MainClass;

public class MenuSceneController {
	private MainClass main;
	private iPlayerManager playerManager;
	
	public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
    }
	
	public void doClickNewGame() {
		System.out.println("New Game");
	}
	
	
	public void doClickLogout() {
		playerManager = new PlayerManager();
		playerManager.logout();
		
		main.initLoginScene();
	}
	
	public void doClickExit() {
		main.stopApplication();
	}
}

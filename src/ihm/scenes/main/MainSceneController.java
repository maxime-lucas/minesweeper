package ihm.scenes.main;

import data.controllers.PlayerManager;
import data.interfaces.iPlayerManager;
import data.models.Player;
import ihm.MainClass;

public class MainSceneController {

	private MainClass main;
	private iPlayerManager playerManager = new PlayerManager();
	
	public void setMainApp(MainClass mainClass) {
		this.main = mainClass;
	}
	
	public void init() {
		Player player = playerManager.getCurrentPlayer();
		System.out.println(player.toString());
	}

}

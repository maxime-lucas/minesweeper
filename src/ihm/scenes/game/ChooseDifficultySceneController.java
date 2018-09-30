package ihm.scenes.game;

import java.sql.Time;

import data.controllers.GameManager;
import data.interfaces.iGameManager;
import data.models.GameDifficulty;
import data.models.GameParameters;
import ihm.MainClass;

public class ChooseDifficultySceneController {
	
	private MainClass main;
	private iGameManager gameManager = new GameManager();
	
	public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
    }
	
	public void doClickBack() {
		this.main.initMenuScene();
	}
	
	public void doClickEasy() {
		doInitGame(GameDifficulty.EASY);
	}
	
	public void doClickMedium() {
		doInitGame(GameDifficulty.MEDIUM);
	}
	
	public void doClickHard() {
		doInitGame(GameDifficulty.HARD);
	}
	
	public void doInitGame(GameDifficulty difficulty) {
		GameParameters gameParameters = new GameParameters();
		gameParameters.setAllowSpectators(false);
		gameParameters.setDifficulty(difficulty);
		gameParameters.setNbMaxPlayer(1);
		gameParameters.setTimerDuration(new Time(0));
		
		//gameManager.startSoloGame(gameParameters);
		
		this.main.initGameScene(difficulty);
	}
	
}

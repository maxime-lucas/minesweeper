package data.controllers;

import data.interfaces.iGameManager;
import data.models.GameParameters;

public class GameManager implements iGameManager {

	@Override
	public void startSoloGame(GameParameters gameParameters) {
		// TODO Auto-generated method stub
		System.out.println(gameParameters);
	}

}

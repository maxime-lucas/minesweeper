package data.controllers;

import data.models.Player;

public class PlayerEngine {
	
	private static PlayerEngine INSTANCE = null;
	
	private Player currentPlayer = null;
	
	private PlayerEngine() {}
	
	public static PlayerEngine getInstance() {
		if( INSTANCE == null ) INSTANCE = new PlayerEngine();
		return INSTANCE;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}

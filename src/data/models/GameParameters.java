package data.models;

import java.io.Serializable;
import java.sql.Time;

public class GameParameters implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean allowSpectators;
	private int nbMaxPlayer;
	private GameDifficulty difficulty;
	private int nbMines;
	private Time timerDuration;
	
	public GameParameters() {
		this.allowSpectators = false;
		this.nbMaxPlayer = 1;
		this.difficulty = GameDifficulty.EASY;
		this.nbMines = 10;
		this.timerDuration = new Time(0);
	}

	public boolean isAllowSpectators() {
		return allowSpectators;
	}

	public void setAllowSpectators(boolean allowSpectators) {
		this.allowSpectators = allowSpectators;
	}

	public int getNbMaxPlayer() {
		return nbMaxPlayer;
	}

	public void setNbMaxPlayer(int nbMaxPlayer) {
		this.nbMaxPlayer = nbMaxPlayer;
	}

	public GameDifficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(GameDifficulty difficulty) {
		this.difficulty = difficulty;
		
		switch(difficulty) {
			case EASY :
				setNbMines(10);
				break;
			case MEDIUM :
				setNbMines(40);
				break;
			case HARD:
				setNbMines(99);
				break;
		}
	}

	public int getNbMines() {
		return nbMines;
	}

	private void setNbMines(int nbMines) {
		this.nbMines = nbMines;
	}

	public Time getTimerDuration() {
		return timerDuration;
	}

	public void setTimerDuration(Time timerDuration) {
		this.timerDuration = timerDuration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		return "{allowSpectators:"+this.allowSpectators
				+",nbMaxPlayer:"+this.nbMaxPlayer
				+",difficulty:"+this.difficulty
				+",nbMines:"+this.nbMines
				+",timerDuration:"+this.timerDuration
				+"}";
	}

}

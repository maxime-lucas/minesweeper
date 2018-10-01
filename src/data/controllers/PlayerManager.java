package data.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import data.interfaces.iPlayerManager;
import data.models.Player;
import exceptions.MissingFieldsException;
import exceptions.NoExistingProfileException;

public class PlayerManager implements iPlayerManager {

	public void login(String login, String password) throws MissingFieldsException, NoExistingProfileException {

		if( login.isEmpty() || password.isEmpty() ) 
			throw new MissingFieldsException();
		
		// check si profil local existe. Si existe pas, creation d'un nouveau profil et stockage du login/password de l'utilisateur
		Player player = new Player();
		player.setLogin(login);
		player.setPassword(password);
		PlayerEngine.getInstance().setCurrentPlayer(player);
		
		throw new NoExistingProfileException();
	}

	@Override
	public void logout() {
		PlayerEngine.getInstance().setCurrentPlayer(null);
	}

	@Override
	public void cancelProfileCreation() {
		logout();
	}

	@Override
	public Player getCurrentPlayer() {
		return PlayerEngine.getInstance().getCurrentPlayer();
	}

	@Override
	public void createProfile(String firstname, String lastname, Integer day, Integer month, Integer year) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    
		java.util.Date birthDate = null;
		try {
			birthDate = (java.util.Date) sdf.parse(year+"-"+month+"-"+day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		PlayerEngine.getInstance().getCurrentPlayer().setFirstname(firstname);
		PlayerEngine.getInstance().getCurrentPlayer().setLastname(lastname);
		PlayerEngine.getInstance().getCurrentPlayer().setDateOfBirth(birthDate);
	}
}

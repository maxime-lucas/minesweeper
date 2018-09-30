package data.controllers;

import data.interfaces.iPlayerManager;
import data.models.Player;
import data.models.Session;
import exceptions.LoginAlreadyExistsException;
import exceptions.MissingCredentialsException;

public class PlayerManager implements iPlayerManager {

	public void login(String login, String password) throws MissingCredentialsException {

		if( login.isEmpty() || password.isEmpty() ) throw new MissingCredentialsException();

		Session.getInstance().login(login);
	}
	
	public void logout() {
		Session.getInstance().logout();
	}

	@Override
	public void register(Player player) throws LoginAlreadyExistsException {
		//if login already used by a local player {
		//	throw new LoginAlreadyExistsException();
		//}
		
		// create a new local profile with 'player'
		
		Session.getInstance().login(player.getLogin());
	}
}

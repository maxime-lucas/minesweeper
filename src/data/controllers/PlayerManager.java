package data.controllers;

import data.MissingCredentialsException;
import data.interfaces.iPlayerManager;

public class PlayerManager implements iPlayerManager {

	public void login(String login, String password) throws MissingCredentialsException {

		if( login.isEmpty() || password.isEmpty() ) throw new MissingCredentialsException();
		
		System.out.println("[data] login");
	}
	
	public void logout() {
		System.out.println("[data] logout");
	}
}

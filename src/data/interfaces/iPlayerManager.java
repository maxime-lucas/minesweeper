package data.interfaces;

import data.MissingCredentialsException;

public interface iPlayerManager {
	public void login(String login, String password) throws MissingCredentialsException;
}

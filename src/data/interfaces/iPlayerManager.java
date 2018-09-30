package data.interfaces;

import data.models.Player;
import exceptions.LoginAlreadyExistsException;
import exceptions.MissingCredentialsException;

public interface iPlayerManager {
	public void login(String login, String password) throws MissingCredentialsException;
	public void register(Player player) throws LoginAlreadyExistsException;
	public void logout();
}

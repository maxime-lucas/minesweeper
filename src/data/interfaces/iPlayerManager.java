package data.interfaces;

import java.sql.Date;

import data.models.Player;
import exceptions.MissingFieldsException;
import exceptions.NoExistingProfileException;

public interface iPlayerManager {
	public void login(String login, String password) throws MissingFieldsException, NoExistingProfileException;
	public void createProfile(String firstname,String lastname, Integer day, Integer month, Integer year);
	public void cancelProfileCreation();
	public void logout();
	public Player getCurrentPlayer();
}

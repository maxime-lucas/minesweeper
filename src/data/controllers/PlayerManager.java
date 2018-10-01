package data.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import data.interfaces.iPlayerManager;
import data.models.Player;
import exceptions.MissingFieldsException;
import exceptions.NoExistingProfileException;

public class PlayerManager implements iPlayerManager {
	public static String filename = "users.txt";
	
	private File getUsersFile() {
		File file = new File(PlayerManager.filename);
		if(!file.exists()) {
			try {
				System.out.println("Création du fichier");
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	public void signup(String login, String password) throws MissingFieldsException {
		if(login.isEmpty() || password.isEmpty()) {
			throw new MissingFieldsException();
		}
		
		File usersFile = getUsersFile();
		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			fos = new FileOutputStream(usersFile, true);
			pw = new PrintWriter(fos);
			// todo add salt or another encryption system
			pw.println(login + ":" + password);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (pw != null)
					pw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}			
	}
	
	private boolean areValidCredentials(String login, String password) throws FileNotFoundException {	
		BufferedReader br = null;
		boolean areValidCredentials = false;

		try {
			br = new BufferedReader(new FileReader(getUsersFile()));
			
	        String st;
			while ((st=br.readLine()) != null && areValidCredentials == false) {
				String data = st.toString();
				final int indexCut = data.indexOf(':');

				if(indexCut != -1) {
					final String testedLogin = data.substring(0, indexCut);
					final String testedEncryptedPassword = data.substring(indexCut + 1, data.length());

					// todo encrypt password before testing matching
					if(login.equals(testedLogin) && password.equals(testedEncryptedPassword)) {
						areValidCredentials = true;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return areValidCredentials;
	}

	public void login(String login, String password) throws MissingFieldsException, NoExistingProfileException {
		try {
			final boolean areValidCredentials = areValidCredentials(login, password);
			System.out.println("Credentials matching: " + areValidCredentials);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if( login.isEmpty() || password.isEmpty() ) 
//			throw new MissingFieldsException();
//		
//		// check si profil local existe. Si existe pas, creation d'un nouveau profil et stockage du login/password de l'utilisateur
//		Player player = new Player();
//		player.setLogin(login);
//		player.setPassword(password);
//		PlayerEngine.getInstance().setCurrentPlayer(player);
//		
//		throw new NoExistingProfileException();
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

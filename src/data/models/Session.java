package data.models;

import java.util.HashMap;

public class Session {
	private static Session instance = null;
	private HashMap<String, Object> data;
	
	private Session() {
		this.data = new HashMap<String,Object>();
	}
	
	public static synchronized Session getInstance() {
		if(instance == null) {
			instance = new Session();
		}
		return instance;
	}
	
	public void login(String login) {
		this.data.put("sessionLogin", login);
	}
	
	public boolean isLogged() {
		if ( this.data.containsKey("sessionLogin") ) {
			String sessionLogin = (String) this.data.get("sessionLogin");
			if( !sessionLogin.isEmpty() ) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public void logout() {
		this.data.remove("sessionLogin");
	}
}

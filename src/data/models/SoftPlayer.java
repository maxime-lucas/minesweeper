package data.models;

import java.io.Serializable;
import java.util.UUID;

public class SoftPlayer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private UUID idPlayer;
	private String login;

	public SoftPlayer() {
		this.idPlayer = UUID.randomUUID();
		this.login = null;
	}
	
	public UUID getIdPlayer() { return idPlayer; }
	public void setIdPlayer(UUID idPlayer) { this.idPlayer = idPlayer; }
	public String getLogin() { return login; }
	public void setLogin(String login) { this.login = login; }
}

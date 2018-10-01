package data.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Player extends SoftPlayer {

	private static final long serialVersionUID = 1L;
	private String password;
	private String firstname;
	private String lastname;
	private java.util.Date dateOfBirth;
	private Integer nbWin;
	private Integer nbForfeit;
	private Integer nbPlay;
	
	public Player() {
		super();
		this.password = null;
		this.firstname = null;
		this.lastname = null;
		this.dateOfBirth = null;
		this.nbWin = 0;
		this.nbForfeit = 0;
		this.nbPlay = 0;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getNbWin() {
		return nbWin;
	}

	public void setNbWin(Integer nbWin) {
		this.nbWin = nbWin;
	}

	public Integer getNbForfeit() {
		return nbForfeit;
	}

	public void setNbForfeit(Integer nbForfeit) {
		this.nbForfeit = nbForfeit;
	}

	public Integer getNbPlay() {
		return nbPlay;
	}

	public void setNbPlay(Integer nbPlay) {
		this.nbPlay = nbPlay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		StringBuilder sb = new StringBuilder();
		sb.append("[Player]");
		sb.append("\n idPlayer=").append(this.getIdPlayer());
		sb.append("\n login=").append(this.getLogin());
		sb.append("\n firstname=").append(this.getFirstname());
		sb.append("\n lastname=").append(this.getLastname());
		sb.append("\n password=").append(this.getPassword());
		sb.append("\n dateOfBirth=").append(sdf.format(this.getDateOfBirth()));
		sb.append("\n nbWin=").append(this.getNbWin());
		sb.append("\n nbForfeit=").append(this.getNbForfeit());
		sb.append("\n nbPlay=").append(this.getNbPlay());
		return sb.toString();
	}

}

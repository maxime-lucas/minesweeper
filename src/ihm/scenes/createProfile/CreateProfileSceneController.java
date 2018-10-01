package ihm.scenes.createProfile;

import java.net.URL;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import data.controllers.PlayerManager;
import data.interfaces.iPlayerManager;
import ihm.MainClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class CreateProfileSceneController implements Initializable{

	private MainClass main;
	private iPlayerManager playerManager = new PlayerManager();
	
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private ComboBox<Integer> cmb_day;
	@FXML
	private ComboBox<Integer> cmb_month;
	@FXML
	private ComboBox<Integer> cmb_year;
	
	public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
    }
	
	public void doClickCancel() {
		playerManager.cancelProfileCreation();
		main.initLoginScene();
	}
	
	@SuppressWarnings("deprecation")
	public void doClickConfirm() {

		String firstnameValue = firstname.getText();
		String lastnameValue = lastname.getText();
		Integer dateOfBirthDay = cmb_day.getValue();
		Integer dateOfBirthMonth = cmb_month.getValue();
		Integer dateOfBirthYear = cmb_year.getValue();
		
		playerManager.createProfile(firstnameValue,lastnameValue,dateOfBirthDay,dateOfBirthMonth,dateOfBirthYear);
		
		main.initMainScene();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Integer> listDay = new ArrayList<Integer>();
		for(int i = 1; i <= 31; i++) listDay.add(i);
		ObservableList<Integer> obListDay = FXCollections.observableList(listDay);
		cmb_day.getItems().clear();
		cmb_day.setItems(obListDay);
		
		List<Integer> listMonth = new ArrayList<Integer>();
		for(int i = 1; i <= 12; i++) listMonth.add(i);
		ObservableList<Integer> obListMonth = FXCollections.observableList(listMonth);
		cmb_month.getItems().clear();
		cmb_month.setItems(obListMonth);
		
		List<Integer> listYear = new ArrayList<Integer>();
		for(int i = 2018; i >= 1918; i--) listYear.add(i);
		ObservableList<Integer> obListYear = FXCollections.observableList(listYear);
		cmb_year.getItems().clear();
		cmb_year.setItems(obListYear);
	}
	
}

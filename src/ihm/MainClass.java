package ihm;

import java.io.IOException;

import data.models.ImageManager;
import ihm.scenes.createProfile.CreateProfileSceneController;
import ihm.scenes.login.LoginSceneController;
import ihm.scenes.main.MainSceneController;
import ihm.scenes.noExistingProfile.NoExistingProfileSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainClass extends Application {
	
	private Stage mainStage;
	private BorderPane mainContainer;

	@Override
	public void start(Stage primaryStage) {
		mainStage = primaryStage;
		mainStage.setTitle("MineSweeper");
		mainStage.setResizable(false);
		mainStage.getIcons().add(ImageManager.getInstance().getIcon());
		
		initMainContainer();
		initLoginScene();
	}
	
	public void stopApplication() {
		mainStage.close();
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void initMainContainer() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("MainContainer.fxml"));
		try {
			mainContainer = (BorderPane) loader.load();
			Scene scene = new Scene(mainContainer);
			String css = getClass().getResource("style.css").toExternalForm();
			scene.getStylesheets().addAll(css);
			mainStage.setScene(scene);
			mainStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initLoginScene() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("scenes/login/LoginScene.fxml"));
		try {
			VBox loginSceneContainer = (VBox) loader.load();
			mainContainer.setCenter(loginSceneContainer);
			
			LoginSceneController loginSceneController = loader.getController();
			loginSceneController.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initNoExistingProfileScene() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("scenes/noExistingProfile/noExistingProfileScene.fxml"));
		try {
			VBox loginSceneContainer = (VBox) loader.load();
			mainContainer.setCenter(loginSceneContainer);
			
			NoExistingProfileSceneController noExistingProfileSceneController = loader.getController();
			noExistingProfileSceneController.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initCreateProfileScene() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("scenes/createProfile/CreateProfileScene.fxml"));
		try {
			VBox createProfileSceneContainer = (VBox) loader.load();
			mainContainer.setCenter(createProfileSceneContainer);
			
			CreateProfileSceneController createProfileSceneController = loader.getController();
			createProfileSceneController.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initMainScene() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("scenes/main/MainScene.fxml"));
		try {
			BorderPane mainSceneContainer = (BorderPane) loader.load();
			
			mainContainer.setCenter(mainSceneContainer);
			
			MainSceneController mainSceneController = loader.getController();
			mainSceneController.setMainApp(this);
			mainSceneController.init();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

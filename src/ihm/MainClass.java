package ihm;

import java.io.IOException;

import ihm.scenes.login.LoginSceneController;
import ihm.scenes.menu.MenuSceneController;
import javafx.application.Application;
import javafx.application.Platform;
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
		
		initMainContainer();
		initLoginScene();
		
		mainStage.setOnCloseRequest(e -> Platform.exit());
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
	
	public void initMenuScene() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("scenes/menu/MenuScene.fxml"));
		try {
			VBox menuSceneContainer = (VBox) loader.load();
			mainContainer.setCenter(menuSceneContainer);
			
			MenuSceneController menuSceneController = loader.getController();
			menuSceneController.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

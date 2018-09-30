package ihm;

import java.io.IOException;

import data.models.GameDifficulty;
import ihm.scenes.game.ChooseDifficultySceneController;
import ihm.scenes.game.easy.GameSceneEasyController;
import ihm.scenes.login.LoginSceneController;
import ihm.scenes.menu.MenuSceneController;
import ihm.scenes.register.RegisterSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
	
	public void initRegisterScene() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("scenes/register/RegisterScene.fxml"));
		try {
			VBox registerSceneContainer = (VBox) loader.load();
			mainContainer.setCenter(registerSceneContainer);
			
			RegisterSceneController registerSceneController = loader.getController();
			registerSceneController.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initChooseDifficultyScene() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("scenes/game/ChooseDifficultyScene.fxml"));
		try {
			VBox chooseDifficultySceneContainer = (VBox) loader.load();
			mainContainer.setCenter(chooseDifficultySceneContainer);
			
			ChooseDifficultySceneController chooseDifficultySceneController = loader.getController();
			chooseDifficultySceneController.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initGameScene(GameDifficulty difficulty) {
		FXMLLoader loader = new FXMLLoader();
		
		switch(difficulty) {
			case EASY:
				loader.setLocation(MainClass.class.getResource("scenes/game/easy/GameSceneEasy.fxml"));
				break;
			case MEDIUM:
				loader.setLocation(MainClass.class.getResource("scenes/game/medium/GameSceneMedium.fxml"));
				break;
			case HARD:
				loader.setLocation(MainClass.class.getResource("scenes/game/hard/GameSceneHard.fxml"));
				break;
		}
		
		try {
			GridPane gameSceneContainer = (GridPane) loader.load();
			mainContainer.setCenter(gameSceneContainer);
			
			GameSceneEasyController gameSceneController = loader.getController();
			gameSceneController.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

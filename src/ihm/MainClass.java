package ihm;

import java.io.IOException;

import ihm.views.LoginSceneController;
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
		
		initMainContainer();
		initLoginScene();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void initMainContainer() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("views/MainContainer.fxml"));
		try {
			mainContainer = (BorderPane) loader.load();
			Scene scene = new Scene(mainContainer);
			mainStage.setScene(scene);
			mainStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initLoginScene() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("views/LoginScene.fxml"));
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
		loader.setLocation(MainClass.class.getResource("views/MenuScene.fxml"));
		try {
			VBox loginSceneContainer = (VBox) loader.load();
			mainContainer.setCenter(loginSceneContainer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

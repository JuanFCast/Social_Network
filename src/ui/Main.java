package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	private SocialNetworkGUI controller;

	public static void main(String[] team) {
		launch(team);
	}

	@Override
	public void start(Stage primaryStage) {
		controller = new SocialNetworkGUI(primaryStage);
		try {
			controller.mainMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

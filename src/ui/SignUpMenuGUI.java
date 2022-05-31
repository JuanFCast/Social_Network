package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpMenuGUI {
	
	private Stage mainStage;
	private SocialNetworkGUI mainController;
	
	public SignUpMenuGUI(Stage stage,  SocialNetworkGUI c) {
		mainStage = stage;
		mainController = c;
	}

	public void start() throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signup_menu.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setTitle("Create a new Account...");
		mainStage.show();
	}
	
}

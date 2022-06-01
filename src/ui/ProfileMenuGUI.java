package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProfileMenuGUI {

	private Stage mainStage;
	private SocialNetworkGUI mainController;
	
	//Constructor
	public ProfileMenuGUI(Stage stage, SocialNetworkGUI c) {
		mainStage = stage;
		mainController = c;
	}
	
	//Methods
	public void start() throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profileMenu.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setTitle("SOCIAL NETWORK");
		mainStage.show();
	}

}

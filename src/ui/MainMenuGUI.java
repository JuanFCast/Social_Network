package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuGUI {
	
	private Stage mainStage;
	private SocialNetworkGUI mainController;
	
	public MainMenuGUI(Stage stage, SocialNetworkGUI c) {
		mainStage = stage;
		mainController = c;
	}
	
	//Methods
	public void start() throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main_menu.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setTitle("SOCIAL NETWORK");
		mainStage.show();
	}
	
	@FXML
    public void signUp(ActionEvent event) throws IOException {
		mainController.signUpMenu();
    }

}

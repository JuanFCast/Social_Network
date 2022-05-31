package ui;

import java.io.IOException;

import javafx.stage.Stage;
import model.SocialNetwork;

public class SocialNetworkGUI {

	//Network
	private SocialNetwork network;
	private Stage mainStage;
	//Menu's
	private MainMenuGUI controllerMainMenu;
	private SignUpMenuGUI controllerSignUpMenu;
	
	//Constructor
	public SocialNetworkGUI(Stage stage){
		network = new SocialNetwork();
		mainStage = stage;
		controllerMainMenu = new MainMenuGUI(mainStage, this);
		controllerSignUpMenu = new SignUpMenuGUI(mainStage, this);
	}
	
	
	
	//Menu´s start
	public void mainMenu() throws IOException {
		controllerMainMenu.start();
	}
	public void signUpMenu() throws IOException {
		controllerSignUpMenu.start();
	}
}

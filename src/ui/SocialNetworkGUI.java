package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.stage.Stage;
import model.Person;
import model.SocialNetwork;

public class SocialNetworkGUI {

	//Network
	private SocialNetwork network;
	private Stage mainStage;
	//Menu's
	private MainMenuGUI controllerMainMenu;
	private SignUpMenuGUI controllerSignUpMenu;
	private ProfileMenuGUI controllerProfileMenu;
	
	//Constructor
	public SocialNetworkGUI(Stage stage){
		network = new SocialNetwork();
		mainStage = stage;
		controllerMainMenu = new MainMenuGUI(mainStage, this);
		controllerSignUpMenu = new SignUpMenuGUI(mainStage, this);
		controllerProfileMenu = new ProfileMenuGUI(mainStage, this);
	}
	
	public void allowAccess(String e, String p) throws IOException {
		Person person = network.searchRegister(new Person(null, e, null));
		
		if(person != null) {
			if(person.getPassword().equals(p)) {
				profileMenu();
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect Password");
			}
		} else {
			JOptionPane.showMessageDialog(null, "The email entered does not belong to any existing user");
		}
	}
	
	public void addRegister(Person p) {
		network.addRegister(p);
	}
	
	public boolean containsRegister(String e) {
		Person p = network.searchRegister(new Person(null, e, null));
		
		if(p != null) {
			return true;
		} else {
			return false;
		}
	}
	
	//Menu´s start
	public void mainMenu() throws IOException {
		controllerMainMenu.start();
	}
	public void signUpMenu() throws IOException {
		controllerSignUpMenu.start();
	}
	public void profileMenu() throws IOException {
		controllerProfileMenu.start();
	}
	
}

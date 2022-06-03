package ui;

import java.io.IOException;
import java.util.List;

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
				profileMenu(person);
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
	
	public List<Person> listContains(String s){
		return network.getListContains(s);
	}
	
	public List<Person> listContainsOrdered(Person p, List<Person> l){
		return network.getSearchListOrder(l, p);
	}
	
	public List<Person> listContacts(Person p){
		return network.getContacts(p);
	}
	
	public boolean addFriend(Person p, Person p2) {
		return network.makeARelation(p, p2);
	}
	
	//Menu´s start
	public void mainMenu() throws IOException {
		controllerMainMenu.start();
	}
	public void signUpMenu() throws IOException {
		controllerSignUpMenu.start();
	}
	public void profileMenu(Person p) throws IOException {
		controllerProfileMenu.start(p);
	}
	
}

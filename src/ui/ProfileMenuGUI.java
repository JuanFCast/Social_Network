package ui;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Person;

public class ProfileMenuGUI {

	private Person currentUser;
	private Person currentProfile;
	private Stage mainStage;
	private SocialNetworkGUI mainController;
	
	@FXML
    private ListView<Person> contacts_listView;
	@FXML
    private ListView<Person> search_listView;
    @FXML
    private Label name_label;
    @FXML
    private TextField search_txtField;
    @FXML
    private Button addToFriend_bttn;
	
	//Constructor
	public ProfileMenuGUI(Stage stage, SocialNetworkGUI c) {
		mainStage = stage;
		mainController = c;
	}
	
	//Methods
	public void start(Person p) throws IOException{
		currentUser = p;
		currentProfile = p;
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profileMenu.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setTitle("SOCIAL NETWORK");
		mainStage.show();
		
		name_label.setText(currentUser.getUserName());
		loadContacts();
	}
	
	@FXML
    public void logout(ActionEvent event) {
		try {
			mainController.mainMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    public void search(ActionEvent event) {
    	search_listView.getItems().clear();
    	if(!search_txtField.getText().equals("")) {
    		search_listView.setVisible(true);
    		
    		String s = search_txtField.getText();
    		List<Person> containsOrdered = mainController.listContainsOrdered(currentProfile, mainController.listContains(s));
    		search_listView.getItems().addAll(containsOrdered);
    	} else {
    		search_listView.setVisible(false);
    	}
    }
    
    @FXML
    public void AddFriend(ActionEvent event) {
    	boolean v = mainController.addFriend(currentUser, currentProfile);
    	
    	if(v) {
    		
    	}
    }

    @FXML
    public void goHome(ActionEvent event) {
    	
    }
    
    @FXML
    public void readValue(MouseEvent event) {
    	currentProfile = search_listView.getSelectionModel().getSelectedItem();
    	List<Person> l = mainController.listContacts(currentProfile);
    	
    	if(currentProfile != currentUser && !l.contains(currentUser)) {
			addToFriend_bttn.setVisible(true);
		} else {
			addToFriend_bttn.setVisible(false);
		}
    	
		contacts_listView.getItems().clear();
    	name_label.setText(currentProfile.getUserName());
    	if(l.isEmpty() == false) {
    		contacts_listView.getItems().addAll(l);
    	}
    }	
    
    private void loadContacts() {
    	List<Person> l = mainController.listContacts(currentProfile);
    	if(l.isEmpty() == false) {
    		contacts_listView.getItems().addAll(l);
    	}
    }
}

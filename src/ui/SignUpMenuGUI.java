package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;

public class SignUpMenuGUI {
	
	private Stage mainStage;
	private SocialNetworkGUI mainController;
	
	@FXML
	private PasswordField confirmPassword_passField;
	@FXML
	private TextField email_txtField;
	@FXML
	private PasswordField password_passField;
	@FXML
	private TextField username_txtField;
	
	//Constructor
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
	
	@FXML
    public void loginMenu(ActionEvent event) throws IOException {
		mainController.mainMenu();
    }
	
	@FXML
	public void signUp(ActionEvent event) {
		if(!username_txtField.getText().equals("")
				&& !email_txtField.getText().equals("")
				&& !password_passField.getText().equals("")
				&& !confirmPassword_passField.getText().equals("")
				) {
			
			String u = username_txtField.getText();
			String e = email_txtField.getText();
			String p = password_passField.getText();
			String p2 = confirmPassword_passField.getText();
			
			if(mainController.containsRegister(e) == false) {
				if(p.equals(p2)) {
					Person person = new Person(u, e, p);
					mainController.addRegister(person);
		    		JOptionPane.showMessageDialog(null, "User created successfully");
		    		username_txtField.clear();
		    		email_txtField.clear();
		    		password_passField.clear();
		    		confirmPassword_passField.clear();
				} else {
		    		JOptionPane.showMessageDialog(null, "Passwords do not match");
				}
			} else {
				JOptionPane.showMessageDialog(null, "There is already a registered user with this email");
			}
		} else {
    		JOptionPane.showMessageDialog(null, "Please, fill in all the fields");
		}
	}
	
}

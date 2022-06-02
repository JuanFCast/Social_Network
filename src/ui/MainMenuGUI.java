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

public class MainMenuGUI {
	
	private Stage mainStage;
	private SocialNetworkGUI mainController;
	
	@FXML
    private TextField username_txtField;
	@FXML
    private PasswordField password_passField;
	
	//Constructor
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

    @FXML
    public void login(ActionEvent event) {
    	if(!username_txtField.getText().equals("") && !password_passField.getText().equals("")) {
    		String username = username_txtField.getText();
    		String password = password_passField.getText();
    		
    		try {
				mainController.allowAccess(username, password);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	} else {
    		JOptionPane.showMessageDialog(null, "Please, fill in all the fields");
    	}
    }

}

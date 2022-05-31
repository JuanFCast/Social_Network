package model;

import util.AVL;
import util.Graph;

public class SocialNetwork {

	private AVL<Person> usersFullName;
	private Graph<Person> network;
	
	public SocialNetwork() {
		network = new Graph<>();
	}
	
	public boolean addRegister() {
	
		return true;
	}
}

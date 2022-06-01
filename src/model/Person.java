package model;

public class Person {
	
	private String userName;
	private String email;
	private String password;
	
	public Person(String u, String e, String p) {
		userName = u;
		email = e;
		password = p;
	}
	
	//Getters & Setters
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
}

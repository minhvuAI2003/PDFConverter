package model;

public class User {
	String email;
	String passwod;
	String name;

	public User(String email, String password) {
		this.email = email;
		this.passwod = password;

	}

	public User(String email, String password, String name) {
		this.email = email;
		this.passwod = password;
		this.name = name;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return this.email;
	}

	public String getName() {
		return this.name;
	}

}

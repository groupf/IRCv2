package main.ch.zhaw.students.groupf.server;

public class User {

	private String _username;
	
	public User(String inUsername) throws IllegalArgumentException {
		
		//TODO Username Validation: allowed is only [a-zA-Z0-9]
		this._username = inUsername;
	}
	
	@Override
	public String toString() {
		return this._username;
	}
}

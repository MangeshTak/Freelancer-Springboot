package com.responseParams;

public class UserLoginResponse {
	int id;
	boolean loggedIn ;
	
	public UserLoginResponse(int id, boolean loggedIn) {
		this.id = id;
		this.loggedIn = loggedIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
}

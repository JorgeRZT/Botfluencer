package com.jolopezp.botfluencer.models;

public class InstaUser {

	private String username;
	private String password;
	private boolean followed;
	
	public boolean getFollowed() {
		return followed;
	}
	
	public void setFollowed(boolean _followed) {
		followed = _followed;
	}
	
	public InstaUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InstaUser(String _username) {
		username = _username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}

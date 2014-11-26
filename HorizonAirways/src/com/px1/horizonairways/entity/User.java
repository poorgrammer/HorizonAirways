package com.px1.horizonairways.entity;

public class User {

	private String userName;
	private String password;
	private boolean isAdmin;

	public User() {

	}

	public User(String userName, String password, boolean isAdmin) {
		super();
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	


}

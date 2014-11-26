package com.px1.horizonairways.entity;

public class User {

	private String userName;
	private String password;
	private boolean admin;

	public User() {

	}

	public User(String userName, String password, boolean isAdmin) {
		super();
		this.userName = userName;
		this.password = password;
		this.admin = isAdmin;
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

	

	public boolean isAdmin(){
		return admin;
	}
	
	public void setAdmin(boolean flag){
		this.admin = flag;
	}


}

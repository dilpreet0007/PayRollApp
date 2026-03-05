package com.employee;

import com.auth.HashPassword;

public class User {
	private String userName;
	private String pass;
	private String role;
	
	public User(String userName,String pass,String role) {
		this.userName = userName;
		this.pass = HashPassword.hashPassword(pass);
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}

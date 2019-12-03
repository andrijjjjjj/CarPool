package com.example.CarPoolApp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id // The userID should be the ID for the user in database.
	private String userID;

	private String password;
	
	private Profile profile;
	private int status;

	protected User() {
	} // May need default constructor for JPA.

	public User(String username, String password, String firstName, String lastName, String phoneNumber, String email,
			int status) {
		this.userID = username;
		this.password = password;
		this.profile = new Profile(firstName, lastName, phoneNumber, email);
		this.status = status;
	}

	public Profile getProfile() {
		return profile;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User: " + userID + " ; Password: " + password + "/";
	}
}

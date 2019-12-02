package com.example.CarPoolApp;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class User {
	
	@Id //The userID should be the ID for the user in database.
	private String userID;
	
	private String password;
	
	private int status;
	
	private Profile profile;
	
	//May need default constructor for JPA.
	
	public User(String userID, String password, int status, String phoneNumber, String fName, String lName)
	{
		this.userID = userID;
		this.password = password;
		this.status = status;
		this.profile = new Profile(fName, lName, phoneNumber);
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
	public String toString()
	{
		return "User: " + userID + " ; Password: " + password + "/";
	}
}

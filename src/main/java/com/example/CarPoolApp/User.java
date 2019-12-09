package com.example.CarPoolApp;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id // The userID should be the ID for the user in database.
	private String userID;

	private String password;
	private Profile profile;

	private int status;

	ArrayList<String> blockedUsers = new ArrayList<String>();

	// Favorites
	ArrayList<String> favorites = new ArrayList<String>();

	protected User() {
	} // May need default constructor for JPA.

	public User(String username, String password, Profile new_profile) {
		this.userID = username;
		this.password = password;
		this.profile = new_profile;
		this.status = 0;
	}

	public User(String username, String password, String firstName, String lastName, String gender, String phoneNumber,
			int status) { //0=inactive 1=active
		this.userID = username;
		this.password = password;
		this.profile = new Profile(firstName, lastName, gender, phoneNumber);
		this.status = status;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
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
		return "User: " + userID + "  Password: " + password;
	}

	public void blockUser(String userID) {
		if (!blockedUsers.contains(userID)) {
			blockedUsers.add(userID);
		}
	}

	public void unBlockUser(String userID) {
		if (blockedUsers.contains(userID)) {
			blockedUsers.remove(userID);
		}
	}

	public ArrayList<String> getBlockedList() {
		return blockedUsers;
	}

	// Favorites
	public void addToFavorites(String userID) {
		if (!favorites.contains(userID)) {
			favorites.add(userID);
		}
	}

	public void removeFromFavorites(String userID) {
		if (favorites.contains(userID)) {
			favorites.remove(userID);
		}
	}

	public ArrayList<String> getFavorites() {
		return favorites;
	}

}

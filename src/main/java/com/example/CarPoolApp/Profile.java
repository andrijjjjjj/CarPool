package com.example.CarPoolApp;

import java.util.ArrayList;

import javax.persistence.Embeddable;

@Embeddable
public class Profile {
	
	private String fName;
	private String lName;
	private String gender;
	private String phoneNumber;
	private double rating;
	ArrayList<Integer> ratings = new ArrayList<Integer>();
	ArrayList<String> comments = new ArrayList<String>();
	
	protected Profile() {}
	
	public Profile(String fName, String lName, String phoneNumber, String gender) {
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.gender=gender;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// Return combined rating
	public double getRating() {
		return rating;
	}
	
	// Returns ratings list
	public ArrayList<Integer> getRatings() {
		return ratings;
	}

	// Adds rating to list and updates rating
	public void setRating(int number) {
		ratings.add(number);
		double ratingNumber = 0;
		for (int temp : ratings) {
			ratingNumber += temp;
		}
		rating = ratingNumber/ratings.size();
	}
	
	// Adds comment to comments list
	public void addComment(String comment) {
		comments.add(comment);
	}
	
	// Gets all comments for user
	public ArrayList<String> getComments() {
		return comments;
	}

	@Override
	public String toString() {
		return "Profile [fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", rating=" + rating + "]";
	}
}

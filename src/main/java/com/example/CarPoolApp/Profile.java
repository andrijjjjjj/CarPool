package com.example.CarPoolApp;

import javax.persistence.Embeddable;

@Embeddable
public class Profile {
	
	private String fName;
	private String lName;
	private String gender;
	private String phoneNumber;
	private int rating;

	protected Profile() {}
	 
	public Profile(String fName, String lName, String gender, String phoneNumber) {
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.rating = 10;//10/10?
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Profile [fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", rating=" + rating + "]";
	}
}

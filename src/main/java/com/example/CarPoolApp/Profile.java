package com.example.CarPoolApp;

public class Profile {
	
	private String fName;
	private String lName;
	private String phoneNumber;
	private String email;

	public Profile(String fName, String lName, String phoneNumber, String email) {
		this.fName = fName;
		this.lName = lName;
		this.phoneNumber = phoneNumber;
		this.email = email;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Profile [fName=" + fName + ", lName=" + lName + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ "]";
	}
}

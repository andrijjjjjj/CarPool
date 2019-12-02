package com.example.CarPoolApp;

public class Profile {
	private String phoneNumber;
	private String fName;
	private String lName;

	public Profile(String fName, String lName, String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.fName = fName;
		this.lName = lName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
}

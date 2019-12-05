package com.example.CarPoolApp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Data {
	
	@NotNull
	private String userID;
	@NotNull
	private String password;

	public String getUserid() {
		return userID;
	}

	public void setUserid(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

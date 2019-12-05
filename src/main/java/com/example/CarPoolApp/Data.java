package com.example.CarPoolApp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

public class Data {
	
	@NotNull
	private String userID;
	@NotNull
	private String password;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String Gender;
	@NotNull
	private String phoneNumber;
	
	private String time;
	private String car;
	private String start;
	private String end;
	private String cost;
	private String maxpass;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getMaxpass() {
		return maxpass;
	}

	public void setMaxpass(String maxpass) {
		this.maxpass = maxpass;
	}

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

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPhonenumber() {
		return phoneNumber;
	}

	public void setPhonenumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}

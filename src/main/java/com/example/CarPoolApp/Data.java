package com.example.CarPoolApp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

public class Data {
	
	@NotEmpty
	private String userID;
	@NotEmpty
	private String password;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String phoneNumber;
	@NotEmpty
	private String time;
	@NotEmpty
	private String car;
	@NotEmpty
	private String start;
	@NotEmpty
	private String end;
	@NotEmpty
	private String cost;
	@NotEmpty
	private Integer maxpass;
	@NotEmpty
	private boolean luggage;
	
	private Integer rating;
	private String comments;
	
	public boolean isLuggage() {
		return luggage;
	}

	public void setLuggage(boolean luggage) {
		this.luggage = luggage;
	}

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
	@NotEmpty
	public String getStartlocation() {
		return start;
	}
	@NotEmpty
	public void setStartlocation(String start) {
		this.start = start;
	}

	public String getEndlocation() {
		return end;
	}

	public void setEndlocation(String end) {
		this.end = end;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Integer getMaxpass() {
		return maxpass;
	}

	public void setMaxpass(Integer maxpass) {
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
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phoneNumber;
	}

	public void setPhonenumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	

}

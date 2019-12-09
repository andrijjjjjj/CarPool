package com.example.CarPoolApp;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class RidePost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ridePostID;
	 
	private String driverUsername;
	private int maxNumPassengers;
	private String date;
	private String time;
	private String car;
	@NotEmpty
	private String startLocation;
	private String endLocation;
	private String cost;
	//private String currentUserID;
	private boolean luggage;
	
	protected RidePost() {}

//	public RidePost(String driverUsername, int maxNumPassengers, String time, String car,
//			String startLocation, String endLocation, String cost, boolean luggageAllowance) {
//		this.driverUsername = driverUsername;
//		this.maxNumPassengers = maxNumPassengers;
//		this.time = time;
//		this.car = car;
//		this.startLocation = startLocation;
//		this.endLocation = endLocation;
//		this.cost = cost;
//		this.hasLuggageAllowance = luggageAllowance;
//	}
//	@NotEmpty
	public RidePost(Integer ridePostID,String driverUserID, String startLocation, String endLocation, String date, String time, String car, String cost, Integer maxpass,boolean luggage) {
		this.driverUsername = driverUserID;
		//this.currentUserID = currentUserID;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.date = date;
		this.time = time;
		this.car = car;
		this.cost = cost;
		this.maxNumPassengers = maxpass;
		this.luggage = luggage;
	}
	
	public Integer getRidePostID() {
		return ridePostID;
	}

//	public String getCurrentUserID() {
//		return currentUserID;
//	}
//
//	public void setCurrentUserID(String currentUserID) {
//		this.currentUserID = currentUserID;
//	}

	public boolean getLuggage() {
		return luggage;
	}

	public void setLuggage(boolean luggage) {
		this.luggage = luggage;
	}

	public String getDriverUsername() {
		return driverUsername;
	}

	public void setDriverUsername(String driverUsername) {
		this.driverUsername = driverUsername;
	}

	public int getMaxNumPassengers() {
		return maxNumPassengers;
	}

	public void setMaxNumPassengers(int maxNumPassengers) {
		this.maxNumPassengers = maxNumPassengers;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public void setRidePostID(Integer ridePostID) {
		this.ridePostID = ridePostID;
	}

	@Override
	public String toString() {
		return "RidePost [ridePostID=" + ridePostID + ", driverUsername=" + driverUsername + ", maxNumPassengers="
				+ maxNumPassengers + ", time=" + time + ", car=" + car + ", startLocation=" + startLocation
				+ ", endLocation=" + endLocation + ", cost=" + cost + ", luggageAllowance=" + luggage + "]";
	}
	
	public void setUniqueID() {
		// Generate unique ID
		int n = 10;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"; 
		StringBuilder sb = new StringBuilder(n); 
		for (int i = 0; i < n; i++) { 
	        int index = (int)(AlphaNumericString.length() * Math.random()); 
	        sb.append(AlphaNumericString.charAt(index)); 
	    } 
		String uniqueID = sb.toString();
		
		// Get all accepted requests for this trip
		PassengerRequestTransaction request = new PassengerRequestTransaction();
		ArrayList<PassengerRequest> acceptedRequests = request.getAllAcceptedPassengers(ridePostID);
		
		Email email = new Email();
		for(int i = 0; i < acceptedRequests.size(); i++) {
			email.emailUniqueID(acceptedRequests.get(i).getPassengerUsername(), uniqueID);
		}
	}
}

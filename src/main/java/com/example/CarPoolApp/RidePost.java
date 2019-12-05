package com.example.CarPoolApp;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RidePost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ridePostID;
	 
	private String driverUsername;
	private int maxNumPassengers;
	private String time;
	private String car;
	private String startLocation;
	private String endLocation;
	private String cost;
	private boolean hasLuggageAllowance;
	
	protected RidePost() {}

	public RidePost(String driverUsername, int maxNumPassengers, String time, String car,
			String startLocation, String endLocation, String cost, boolean luggageAllowance) {
		this.driverUsername = driverUsername;
		this.maxNumPassengers = maxNumPassengers;
		this.time = time;
		this.car = car;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.cost = cost;
		this.hasLuggageAllowance = luggageAllowance;
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

	public int getRidePostID() {
		return ridePostID;
	}

	public void setRidePostID(int ridePostID) {
		this.ridePostID = ridePostID;
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

	public boolean getHasLuggageAllowance() {
		return hasLuggageAllowance;
	}

	public void setHasLuggageAllowance(boolean hasLuggageAllowance) {
		this.hasLuggageAllowance = hasLuggageAllowance;
	}

	public void setRidePostID(Integer ridePostID) {
		this.ridePostID = ridePostID;
	}

	@Override
	public String toString() {
		return "RidePost [ridePostID=" + ridePostID + ", driverUsername=" + driverUsername + ", maxNumPassengers="
				+ maxNumPassengers + ", time=" + time + ", car=" + car + ", startLocation=" + startLocation
				+ ", endLocation=" + endLocation + ", cost=" + cost + ", luggageAllowance=" + hasLuggageAllowance + "]";
	}
}

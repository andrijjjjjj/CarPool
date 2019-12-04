package com.example.CarPoolApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PassengerRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int passengerRequestID;
	
	private int waitingAcceptedDeclined;//1 = waiting, 2 = accepted, 3 = declined.
	private int ridePostID;
	private String passengerUsername;
	 
	protected PassengerRequest() {}

	public PassengerRequest(int ridePostID, String passengerUsername) {
		this.waitingAcceptedDeclined = 1;
		this.ridePostID = ridePostID;
		this.passengerUsername = passengerUsername;
	}

	public int getPassengerRequestID() {
		return passengerRequestID;
	}

	public void setPassengerRequestID(int passengerRequestID) {
		this.passengerRequestID = passengerRequestID;
	}

	public int getWaitingAcceptedDeclined() {
		return waitingAcceptedDeclined;
	}

	public void setWaitingAcceptedDeclined(int waitingAcceptedDeclined) {
		this.waitingAcceptedDeclined = waitingAcceptedDeclined;
	}

	public int getRidePostID() {
		return ridePostID;
	}

	public void setRidePostID(int ridePostID) {
		this.ridePostID = ridePostID;
	}

	public String getPassengerUsername() {
		return passengerUsername;
	}

	public void setPassengerUsername(String passengerUsername) {
		this.passengerUsername = passengerUsername;
	}

	@Override
	public String toString() {
		return "PassengerRequest [passengerRequestID=" + passengerRequestID + ", waitingAcceptedDeclined="
				+ waitingAcceptedDeclined + ", ridePostID=" + ridePostID + ", passengerUsername=" + passengerUsername
				+ "]";
	}
}

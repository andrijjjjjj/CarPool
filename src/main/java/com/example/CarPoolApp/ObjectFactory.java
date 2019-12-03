package com.example.CarPoolApp;

public class ObjectFactory {
//	public String makePassengerRequest(int ridePostID, String passengerUsername) {
//		// Make passengerRequest instance.
//
//		// Save to database using passengerRequestTransaction.
//	}
	public User createUser(String username, String password, String phoneNumber, String emailAddress, String firstName,
			String lastName) {
		// boolean validated=false;
		// validate(username,password,phoneNumber,emailAddress,firstName,lastName);
		Profile new_profile = new Profile(firstName, lastName, phoneNumber, emailAddress);
		User new_user = new User(username, password, new_profile);
		return new_user;
	}

}

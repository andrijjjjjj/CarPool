package com.example.CarPoolApp;

import org.springframework.stereotype.Component;

@Component
public class ObjectFactory {
//	public String makePassengerRequest(int ridePostID, String passengerUsername) {
//		// Make passengerRequest instance.
//
//		// Save to database using passengerRequestTransaction.
//	}
	public User createUser(String username, String password, String phoneNumber, String firstName,
			String lastName,String gender) {
		Profile new_profile = new Profile(firstName, lastName, phoneNumber,gender );
		User new_user = new User(username, password, new_profile);
		return new_user;
	}
}
//"http://www.screenprank.com/gandalf.html"

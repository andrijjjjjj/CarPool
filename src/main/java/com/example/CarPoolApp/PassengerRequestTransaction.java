package com.example.CarPoolApp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassengerRequestTransaction {

	@Autowired
	PassengerRequestRepository passengerRequests;

	@Autowired
	RidePostTransaction ridePostTransaction;

	@Autowired
	UserTransaction userTransaction;

	Email emailSender;
//	@Autowired
//	UserRepository userRepo; DONT USE THIS ONE. USE TRANSACTION CLASS.

	public PassengerRequest getPassengerRequest(int passengerRequestID) {
		return passengerRequests.findById(passengerRequestID).get();
	}

	public ArrayList<PassengerRequest> getAllPassengerRequests() {
		return passengerRequests.findAll();

		// DONT REMOVE. TEST THIS METHOD WORKS FIRST.
//		Iterable<PassengerRequest> iterable = passengerRequests.findAll();
//		ArrayList<PassengerRequest> result = new ArrayList<PassengerRequest>();
//		iterable.forEach(result::add);
//		return result;

	}

	public void passengerAcceptedForRide(String username) {

	}

	public ArrayList<PassengerRequest> getAllPassengerRequests(int ridePostID) {
		// Get all passenger requests for a specific ridePost, using that ridePost's ID.
		ArrayList<PassengerRequest> result = passengerRequests.findAllByRidePostID(ridePostID);
		return result;
	}

	public String cancelRide(int passengerRequestID) {
		// Prompt are you sure? If yes, delete. If no, end.
		// TODO How do? Make another method that brings up a different UI to confirm. If
		// confirmed, call this method!

		// Get passengerRequest. Get ridePost. Get owner User. Send notification.
		int ridePostID = passengerRequests.findById(passengerRequestID).get().getRidePostID();
		RidePost ridePost = ridePostTransaction.getRidePost(ridePostID);
		String driverID = ridePost.getDriverUsername();
		User driver = userTransaction.getUser(driverID);

		// Send email to driver
		Email email = new Email();
		email.emailPassengerCancelled(driver); // TODO Test that this works!

		// Delete passengerRequest.
		passengerRequests.deleteById(passengerRequestID);

		// Print confirmation.
		return "Passenger request " + passengerRequestID + " was deleted.";
	}

	// this actually returns all of the rideRequests. Filters them out in
	// ridePostTransaction viewUpcomingRides
	public ArrayList<PassengerRequest> getAcceptedRequests(String passengerUsername) {

		// Stores the accepted requests. Used in ridePostTransaction to
		// viewUpcomingRides
		ArrayList<PassengerRequest> acceptedRequests = passengerRequests.findAllByPassengerUsername(passengerUsername);

		return acceptedRequests;
	}

	public String savePassengerRequest(int ridePostID, String passengerUsername) {
		// Get ridePost.
		RidePost ride = ridePostTransaction.getRidePost(ridePostID);

		// Check if ride is full. If yes, print ride full confirmation.
		if (getAllPassengerRequests(ridePostID).size() >= ride.getMaxNumPassengers()) {
			return "Sorry! That ride is full!";
		} else {
			// Make new passenger request object.
			PassengerRequest newRequest = new PassengerRequest(ridePostID, passengerUsername);

			// Send email notification to driver.
			String driverID = ride.getDriverUsername();
			User driver = userTransaction.getUser(driverID);
			Email email = new Email();
			email.emailDriverPassengerRequested(driver);

			// Save to database.
			passengerRequests.save(newRequest);

			// Return confirmation.
			return "Passenger request " + newRequest.getPassengerRequestID() + " created!";
		}
	}

	public void deletePassengerRequest(int passengerRequestID) {
		passengerRequests.deleteById(passengerRequestID);
	}

	public ArrayList<PassengerRequest> viewPendingRides(String username) {

		ArrayList<PassengerRequest> pendingRequests = passengerRequests.findAllByPassengerUsername(username);
		return pendingRequests;
	}

	// returns an array list of requests for a specific ride post.
	public ArrayList<PassengerRequest> viewPassengerRequests(String username, int ridePostID) {

		// stores all passenger requests for a ride post
		ArrayList<PassengerRequest> thePassengerRequests = passengerRequests.findAllByRidePostID(ridePostID);

		// remove the blocked users from the lists. calls helper method
		thePassengerRequests = removeBlockedUsers(username, thePassengerRequests);

		// Driver still has to make decision, not just view them.

		return thePassengerRequests;
	}

	// removes all of the blocked users from an arrayList
	public ArrayList<PassengerRequest> removeBlockedUsers(String username, ArrayList<PassengerRequest> theArray) {
		// We must remove the blocked user, if there are any, from the list before
		// returning
		// retrieving the Users blocked list
		User theUser = userTransaction.getUser(username);
		ArrayList<String> blockedList = theUser.getBlockedList();

		// Loop through passenger requests
		for (int i = 0; i < theArray.size(); i++) {
			// Loop through blocked list
			for (int j = 0; j < blockedList.size(); j++) {

				if (theArray.get(i).getPassengerUsername() == blockedList.get(j)) {
					// remove the blocked person from the list
					theArray.remove(i);
				}
			}
		}
		return theArray;
	}

	public ArrayList<PassengerRequest> getAllAcceptedPassengers(int ridePostID) {
		// Get all passenger requests for a specific ridePost, using that ridePost's ID.
		ArrayList<PassengerRequest> result = passengerRequests.findAllByRidePostID(ridePostID);
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getWaitingAcceptedDeclined() != 2) {
				result.remove(i);
			}
		}
		return result;
	}
}

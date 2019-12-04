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

	public PassengerRequest getPassengerRequest(int passengerRequestID)
	{
		return passengerRequests.findById(passengerRequestID).get();
	}
	
	public ArrayList<PassengerRequest> getAllPassengerRequests()
	{
		Iterable<PassengerRequest> iterable = passengerRequests.findAll();
		ArrayList<PassengerRequest> result = new ArrayList<PassengerRequest>();
		iterable.forEach(result::add);
		return result;
	}
	
	public ArrayList<PassengerRequest> getAllPassengerRequests(int ridePostID)
	{
		Iterable<PassengerRequest> iterable = passengerRequests.findAllByRidePostID(ridePostID); //If this doesnt work, do commented part below.
		ArrayList<PassengerRequest> result = new ArrayList<PassengerRequest>();
		iterable.forEach(result::add);
		return result;
//		//Get all passengerRequests OR find way to get very specific passengerRequests from database.
//		ArrayList<PassengerRequest> requests = getAllPassengerRequests()
//
//		//Loop through each ride post and compare to ridePostID. If they match, add to result list.
//		ArrayList<PassengerRequest> result = new ArrayList<PassengerRequest>();
//
//		for(PassengerRequest request : requests)
//		{
//			//If...
//			if(request.getRidePostID() == ridePostID)
//			result.add(request);
//		}
//
//		return result;
	}
	
	public String cancelRide(int passengerRequestID)
	{
		//Prompt are you sure? If yes, delete. If no, end. 
		//TODO How do? Make another method that brings up a different UI to confirm. If confirmed, call this method!

		//Get passengerRequest. Get ridePost. Get owner User. Send notification.
		int ridePostID = passengerRequests.findById(passengerRequestID).get().getRidePostID();
		RidePost ridePost = ridePostTransaction.getRidePost(ridePostID);
		String driverID = ridePost.getDriverUsername();
		User driver = userTransaction.getUser(driverID);
		
		//Send email to driver
		Email email = new Email();
		email.emailPassengerCancelled(driver); //TODO Test that this works!
		
		//Delete passengerRequest.
		passengerRequests.deleteById(passengerRequestID);

		//Print confirmation.
		return "Passenger request " + passengerRequestID + " was deleted.";
	}
	
	//this actually returns all of the rideRequests. Filters them out in  ridePostTransaction viewUpcomingRides
	public ArrayList<PassengerRequest> getAcceptedRequests(String passengerUsername){
		
		//Stores the accepted requests. Used in ridePostTransaction to viewUpcomingRides
		ArrayList<PassengerRequest> acceptedRequests = passengerRequests.findAllByPassengerUsername(passengerUsername);
		
		return acceptedRequests;
	}

	public String savePassengerRequest(int ridePostID, String passengerUsername)
	{
		//Get ridePost.
		RidePost ride = ridePostTransaction.getRidePost(ridePostID);

		//Check if ride is full. If yes, print ride full confirmation.
		if(getAllPassengerRequests(ridePostID).size() >= ride.getMaxNumPassengers())
		{
			return "Sorry! That ride is full!";
		}
		else
		{
			//Make new passenger request object.
			PassengerRequest newRequest = new PassengerRequest(ridePostID, passengerUsername);
			
			//Send email notification to driver.
			String driverID = ride.getDriverUsername();
			User driver = userTransaction.getUser(driverID);
			Email email = new Email();
			email.emailDriverPassengerRequested(driver);
			
			//Save to database.
			passengerRequests.save(newRequest);

			//Return confirmation.
			return "Passenger request " + newRequest.getPassengerRequestID() + " created!";
		}
	}
	
	public void deletePassengerRequest(int passengerRequestID)
	{
		passengerRequests.deleteById(passengerRequestID);
	}

	
	public ArrayList<PassengerRequest> viewPendingRides(String username){
		
		ArrayList<PassengerRequest> pendingRequests = passengerRequests.findAllByPassengerUsername(username);
		return pendingRequests;
	}
	
	//returns an array list of requests for a specific ride post. 
	public ArrayList<PassengerRequest> viewPassengerRequests(String username, int ridePostID){
		ArrayList<PassengerRequest> thePassengerRequests = passengerRequests.findAllByRidePostID(ridePostID);
		
		//Driver still has to make decision, not just view them.
		
		return thePassengerRequests;
	}
	
}

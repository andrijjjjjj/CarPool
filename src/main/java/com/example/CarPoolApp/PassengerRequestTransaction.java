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
		//TODO How do?

		//Get passengerRequest. Get ridePost. Get owner User. Send notification.
		int ridePostID = passengerRequests.findById(passengerRequestID).get().getRidePostID();
		RidePost ridePost = ridePostTransaction.getRidePost(ridePostID);
		String driverID = ridePost.getDriverUsername();
		User driver = userTransaction.getUser(driverID);
		//TODO Send email to driver
		
		//Delete passengerRequest.
		passengerRequests.deleteById(passengerRequestID);

		//Print confirmation.
		return "Passenger request " + passengerRequestID + " was deleted.";
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
}

package com.example.CarPoolApp;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RidePostTransaction {
	
	@Autowired
	PassengerRequestTransaction passengerRequestTransaction;
	
	@Autowired
	RidePostRepository ridePosts;
	
	@Autowired
	UserTransaction userTransaction;
	
	public RidePost getRidePost(int ridePostID)
	{
		return ridePosts.findById(ridePostID).get();
	}
	
	public ArrayList<RidePost> getAllRidePosts()
	{
		Iterable<RidePost> iterable = ridePosts.findAll();
		ArrayList<RidePost> result = new ArrayList<RidePost>();
		iterable.forEach(result::add);
		return result;
	}
	
	public ArrayList<RidePost> getAllRidePosts(int driverGender, int driverRating, String carPreference, int cost, boolean luggageAllowance)
	{
		//Get all rideposts OR find way to get very specific ridePosts from database.
		ArrayList<RidePost> rides = getAllRidePosts();
		
		//Loop through each ride post and compare to restrictions. If they match, add to result list.
		ArrayList<RidePost> result = new ArrayList<RidePost>();
		User driver;
		for( RidePost ride : rides)
		{
			driver = userTransaction.getUser(ride.getDriverUsername());
			//if()//TODO compare all restrictions. //1. driver gender. //2. driver rating. //3. ridePost car and carPreference. //4. ridePost cost and cost. //5. ridePost luggageAllowance and luggageAllowance.
			result.add(ride);
		}
		
		return result;
	}
	
	public ArrayList<RidePost> viewUpcomingRides(String driverUsername){
		
		//Stores the ride posts the user has posted themselves
		ArrayList<RidePost> rides = ridePosts.findByDriverUsername(driverUsername);
		
		ArrayList<PassengerRequest> rides2 = passengerRequestTransaction.getAcceptedRequests(driverUsername);
		
		//filter out the passengerRequests to only those accepted
		for(int i = 0; i<rides2.size(); i++) {
			if(!(rides2.get(i).getWaitingAcceptedDeclined() == 2)) {
				rides2.remove(i);
			}
		}
		
		//find the corresponding ridePosts of the passengerRequests. based on ridePostID. add them to original list
		for(int i = 0; i<rides2.size(); i++) {
			Integer ID = rides2.get(i).getRidePostID();
			RidePost ridePost = ridePosts.findById(ID).get();
			rides.add(ridePost);
			
		}
		return rides;
	}
	
	
	
	public String removeRidePost(int ridePostID)
	{
		//Prompt are you sure? If yes, delete. If no, end.
		//TODO How do?
				
		//Get all passengerRequests for ridePostID. Loop through and send emails to passengerRequestOwners.
		ArrayList<PassengerRequest> passengerRequests = passengerRequestTransaction.getAllPassengerRequests(ridePostID);
		User requestOwner;
		for(PassengerRequest request : passengerRequests)
		{
			requestOwner = userTransaction.getUser(request.getPassengerUsername());
			//TODO Send email with requestOwner.
			//Delete passengerRequest.
			passengerRequestTransaction.deletePassengerRequest(request.getPassengerRequestID());
		}
				
		//Delete ridepost.
		ridePosts.deleteById(ridePostID);
				 
		//Print confirmation.
		return "RidePost " + ridePostID + " was deleted.";
	}
}

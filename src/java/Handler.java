/**
 * 
 */
package java;

import java.util.ArrayList;

public class Handler 
{

	
	public ArrayList<RidePost> viewAllRides()
	{
		//Call the method getAllRidePosts() from RidePostTransaction.
		//Return the resulting arrayList of RidePosts.
		return RidePostTransaction.getAllRidePosts();				
	}
	
	public ArrayList<RidePost> viewAllRides(String restrictions)
	{
		
	}
	
	public String removeRidePost(int ridePostID) //confirmation
	{
		
	}
	
	public String cancelRide(int passengerRequestID)
	{
		
	}
	
	public String makePassengerRequest(int ridePostID, String passengerUsername)
	{
		
	}
	
	//Static classes arent static in here. They are their own objects/classes with static methods!
}

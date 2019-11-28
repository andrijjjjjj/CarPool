/**
 * 
 */
package java;

import java.util.ArrayList;

public class Handler 
{

	
	public ArrayList<RidePost> viewAllRides()
	{
		
		
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
	
	
	//Static classes go here:
	static class ObjectFactory
	{
		public String makePassengerRequest(int ridePostID, String passengerUsername)
		{
			//Make passengerRequest instance. 
			
			//Save to database using passengerRequestTransaction.
		}
	}
	
	static class RidePostTransaction
	{
		private DatabaseQuery query;
		
		public ArrayList<RidePost> getAllRidePosts()
		{
			//Create query object
		}
	}
	
	static class PassengerRequestTransaction
	{
		private DatabaseQuery query;
		
		public String savePassengerRequest(PassengerRequest newRequest)
		{
			//Makes a new database query instance? Or should be static?
			//Use instance to connect to database.
		}
	}
	
	static class UserTransaction
	{
		private DatabaseQuery query;
		
		
	}
	}
}

package com.example.CarPoolApp;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRequestRepository extends JpaRepository<PassengerRequest, Integer> {
	@Override
	ArrayList<PassengerRequest> findAll();//This may not work! If so, just remove and uncomment commented code in Transaction class for  getAllPassengerRequests().
	
	ArrayList<PassengerRequest> findAllByRidePostID(int ridePostID);
	
	ArrayList<PassengerRequest> findAllByPassengerUsername(String passengerusername);
	
	 
	
}

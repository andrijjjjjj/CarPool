package com.example.CarPoolApp;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRequestRepository extends JpaRepository<PassengerRequest, Integer> {
	
	ArrayList<PassengerRequest> findAllByRidePostID(int ridePostID);
	ArrayList<PassengerRequest> findAllByPassengerUsername(String passengerUsername);
	
	
}

package com.example.CarPoolApp;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface PassengerRequestRepository extends CrudRepository<PassengerRequest, Integer> {
	
	ArrayList<PassengerRequest> findAllByRidePostID(int ridePostID);
	
}

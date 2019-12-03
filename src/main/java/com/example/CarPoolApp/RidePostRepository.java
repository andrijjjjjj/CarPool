package com.example.CarPoolApp;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RidePostRepository extends JpaRepository<RidePost, Integer> {
	//RidePost findByridePostID(Integer ridePostID); //Doesnt work this way? OR Unneccessary.
	 ArrayList<RidePost> findByDriverUsername(String driverUsername);
	
}

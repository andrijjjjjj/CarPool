package com.example.CarPoolApp;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RidePostRepository extends JpaRepository<RidePost, Integer> {
	@Override
	ArrayList<RidePost> findAll(); //This may not work! If so, just remove and uncomment commented code in Transaction class for  getAllRidePosts().
	
	ArrayList<RidePost> findByDriverUsername(String driverUsername);
	
}

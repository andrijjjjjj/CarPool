package com.example.CarPoolApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RidePostRepository extends JpaRepository<RidePost, Integer> {
	RidePost getRidePostByID(Integer ridePostID);
	
}

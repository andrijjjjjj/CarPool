package com.example.CarPoolApp;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface RidePostRepository extends CrudRepository<RidePost, Integer> {
	RidePost getRidePostByID(Integer ridePostID);
	
	
}

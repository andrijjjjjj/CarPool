package com.example.CarPoolApp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.CarPoolApp.User;

public interface UserTransaction extends CrudRepository<User, String> {
	
	//private DatabaseQuery query;
	
	List<User> findListByStatus(int status);
	
	User findUserByID(String userID);
}

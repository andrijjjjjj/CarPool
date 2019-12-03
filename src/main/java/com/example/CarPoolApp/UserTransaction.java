package com.example.CarPoolApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTransaction {
	
	@Autowired
	UserRepository users;
	
	public User getUser(String userID)
	{
		return users.findById(userID).get();
	}
	
	//private DatabaseQuery query;
	
//	List<User> findListByStatus(int status);
//	
//	User findUserByID(String userID);
}

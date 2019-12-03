package com.example.CarPoolApp;

import org.springframework.beans.factory.annotation.Autowired;

public class UserTransaction {

	@Autowired
	UserRepository users;

	public User getUser(String userID) {
		return users.findById(userID).get();
	}

	public boolean saveNewUser(User user_obj) {
		User temp = users.save(user_obj);
		if (temp == user_obj) {
			return true;
		} else {
			return false;
		}
	}
	// private DatabaseQuery query;

//	List<User> findListByStatus(int status);
//	
//	User findUserByID(String userID);
}

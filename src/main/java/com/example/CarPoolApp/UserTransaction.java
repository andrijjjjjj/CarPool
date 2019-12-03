package com.example.CarPoolApp;

import org.springframework.beans.factory.annotation.Autowired;

public class UserTransaction {

	@Autowired
	UserRepository users;
	@Autowired
	Email emailSender;

	public User getUser(String userID) {
		return users.findById(userID).get();
	}

	public String deleteAccount(String username) {
		
		users.deleteById(username);
		return "deleted Account "+username;
	}

	public boolean saveNewUser(User user_obj) {
		User temp = users.save(user_obj);
		if (temp == user_obj) {
			emailSender.emailSignUp(temp);
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

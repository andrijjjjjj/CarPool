package com.example.CarPoolApp;

import java.util.ArrayList;

import javax.validation.constraints.AssertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTransaction {

	@Autowired
	UserRepository users;

	Email emailSender = new Email();

	private static final Logger log = LoggerFactory.getLogger(UserTransaction.class);

	public User getUser(String userID) {

		return users.findById(userID).get();
	}
	@AssertTrue
	public boolean verifyLogin(String userID, String password) {
		if(users.existsById(userID)) {
			if(users.findById(userID).get().getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public String deleteAccount(String username) {

		users.deleteById(username);
		return "deleted Account " + username;
	}

	public void updateProfile(String username, String phoneNumber, String firstName, String lastName, String gender, ArrayList<Integer> ratings, ArrayList<String> comments) {
		String password = users.findById(username).get().getPassword();
		User user = new User(username, password, firstName, lastName, gender, phoneNumber, 1);
		user.getProfile().comments = comments;
		user.getProfile().ratings = ratings;
		users.save(user);
	}

//	public boolean saveNewUser(User user_obj) {
//		User temp = users.save(user_obj);
//		if (temp.getUserID() == user_obj.getUserID()) {
//			 //3
//			//emailSender.emailSignUp(user_obj);
//			return true;
//		} else {
//			return false;
//		}
//	}
	public void saveUser(Data data) {
		int status = 0;//Setting status to inactive. Awaiting email confirmation
		User user = new User(data.getUserid(), data.getPassword(), data.getFirstname(), data.getLastname(), data.getGender(), data.getPhonenumber(), status);
		users.save(user);
		emailSender.emailSignUp(user);
	}


}

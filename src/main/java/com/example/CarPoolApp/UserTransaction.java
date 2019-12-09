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
		if (users.existsById(userID) && users.findById(userID).get().getStatus() == 1) {
			if (users.findById(userID).get().getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public boolean emailreset(String userID) {
		if (users.existsById(userID)) {
			User temp = users.findById(userID).get();
			emailSender.emailreset(temp);
			return true;
		}
		System.out.println("user ID null in reset");
		return false;
	}

	public boolean passwordChange(String userID, String new_passsword) {
			if(users.existsById(userID)) {
				User temp=users.findById(userID).get();
				temp.setPassword(new_passsword);
				users.save(temp);
				return true;
			}
			return false;
	}

	public String deleteAccount(String username) {

		users.deleteById(username);
		return "deleted Account " + username;
	}

	public void updateProfile(String username, String phoneNumber, String firstName, String lastName, String gender,
			ArrayList<Integer> ratings, ArrayList<String> comments) {
		String password = users.findById(username).get().getPassword();
		User user = new User(username, password, firstName, lastName, gender, phoneNumber, 1);
		user.getProfile().comments = comments;
		user.getProfile().ratings = ratings;
		users.save(user);
	}

	public User getFeedback(String username) {

		return users.findById(username).get();
	}

	public boolean emailconfirmation(String userID, Data data) {
		System.out.println("id: " + userID);
		if (users.existsById(userID)) {
			User temp = users.findById(userID).get();

			temp.setStatus(1);
			// theres no way thats it
			users.save(temp);
			return true;
		}
		return false;
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
		int status = 0;// Setting status to inactive. Awaiting email confirmation
		User user = new User(data.getUserid(), data.getPassword(), data.getFirstname(), data.getLastname(),
				data.getGender(), data.getPhonenumber(), status);
		users.save(user);
		emailSender.emailSignUp(user);
	}

	public void updateUser(User user) {
		users.save(user);
	}

}

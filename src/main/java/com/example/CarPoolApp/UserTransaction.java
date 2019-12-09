package com.example.CarPoolApp;

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

	public String deleteAccount(String username) {

		users.deleteById(username);
		return "deleted Account " + username;
	}

	public void updateProfile(String username, String phoneNumber, String firstName, String lastName, String gender) {
		User temp = users.findById(username).get();
		String keep_pass = temp.getPassword();
		users.delete(temp);
		Profile new_profile = new Profile(firstName, lastName, gender, phoneNumber);
		User temp2 = new User(username, keep_pass, new_profile);
		users.save(temp2);
	}

	public boolean emailconfirmation(String userID, Data data) {
		System.out.println("id: "+userID);
		if (users.existsById(userID)) {
			User temp = users.findById(userID).get();
			System.out.println("id: " + temp.getUserID() + " name: " + temp.getProfile().getfName() + " "
					+ temp.getProfile().getlName() + " phone: " + temp.getProfile().getPhoneNumber() + " status: "
					+ temp.getStatus() + " gender " + temp.getProfile().getGender() + " rating"
					+ temp.getProfile().getRating());
			temp.setStatus(1);
			System.out.println("id: " + temp.getUserID() + " name: " + temp.getProfile().getfName() + " "
					+ temp.getProfile().getlName() + " phone: " + temp.getProfile().getPhoneNumber() + " status: "
					+ temp.getStatus() + " gender " + temp.getProfile().getGender() + " rating"
					+ temp.getProfile().getRating());
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

}

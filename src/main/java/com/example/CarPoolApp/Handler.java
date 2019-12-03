/**
 * 
 */
package com.example.CarPoolApp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class Handler {

	// Transaction classes go here? Autowired?
	@Autowired
	RidePostTransaction ridePostTransaction;
	@Autowired
	UserTransaction userTransaction;
	@Autowired
	PassengerRequestTransaction passengerRequestTransaction;
	@Autowired
	ObjectFactory objFactory;

	@GetMapping("/login")
	public String enterLogin(Model model) {
		model.addAttribute("users", new User());
		return "login";

	}

	@PostMapping("/login")
	public String exitLogin(@ModelAttribute User user) {
		return "home";
	}

	public boolean signUp(String username, String password, String phoneNumber, String emailAddress, String firstName,
			String lastName) {
		User temp = objFactory.createUser(username, password, phoneNumber, emailAddress, firstName, lastName);
		return userTransaction.saveNewUser(temp);
	}

	public ArrayList<RidePost> viewAllRides() {
		return ridePostTransaction.getAllRidePosts();
	}

	public ArrayList<RidePost> viewAllRides(int driverGender, int driverRating, String carPreference, int cost,
			boolean luggageAllowance) {// Leave box blank if no preference for variable //driverGender(0 = dont care, 1
										// = male, 2 = female, 3 = other).
		return ridePostTransaction.getAllRidePosts(driverGender, driverRating, carPreference, cost, luggageAllowance);
	}

	public String removeRidePost(int ridePostID) // confirmation
	{
		return ridePostTransaction.removeRidePost(ridePostID);
	}

	public String cancelRide(int passengerRequestID) {
		return passengerRequestTransaction.cancelRide(passengerRequestID);
	}

	public String makePassengerRequest(int ridePostID, String passengerUsername) {
		return passengerRequestTransaction.savePassengerRequest(ridePostID, passengerUsername);
	}

}

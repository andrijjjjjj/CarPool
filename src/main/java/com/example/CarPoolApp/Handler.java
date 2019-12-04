/**
 * 
 */
package com.example.CarPoolApp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@EnableWebMvc
public class Handler {
	
	//Transaction classes go here. Autowire them.
	@Autowired
	RidePostTransaction ridePostTransaction;
	@Autowired
	PassengerRequestTransaction passengerRequestTransaction;
	@Autowired
	UserTransaction userTransaction;
	
	String currentUserID = "Michael"; //This instantiation is for tests. This variable should be set by calling the login method. Can use this method to determine if a user is logged in(null = not logged in).
	
	@RequestMapping("/")//The initial page of the website. Should have buttons for sign-up, login, forgot password.
	public String loadInitialPage() {
		return "welcomepage";
	}
	
	@RequestMapping("/login")//The login page of the website.
	public String loadLoginPage() throws ServletException, IOException {

		return "loginpage";
	}
	
	@RequestMapping("/home")//The home page of the website. Should have buttons for most use cases... EX: view all rides.
	public String loadHomePage(Model model) {
		model.addAttribute("currentUserID", currentUserID); //This allows the html page to access the currentUserID variable. Can put methods in this call too.
		
		return "homepage";
	}
		
	
	//Mapping methods! ^^^^^
	//Logic methods! vvvvv
	
	public ArrayList<RidePost> viewAllRides() {
		return ridePostTransaction.getAllRidePosts();
	}

	public ArrayList<RidePost> viewAllRides(String driverGender, int driverRating, String carPreference, String cost, boolean luggageAllowance) {//Leave box blank if no preference for variable. 
		return ridePostTransaction.getAllRidePosts(driverGender,driverRating,carPreference,cost,luggageAllowance);
	}

	public String removeRidePost(int ridePostID) // confirmation
	{
		return ridePostTransaction.removeRidePost(ridePostID);
	}

	public String cancelRide(int passengerRequestID) {
		return passengerRequestTransaction.cancelRide(passengerRequestID);
	}

	public String makePassengerRequest(int ridePostID, String passengerUsername) {
		return passengerRequestTransaction.savePassengerRequest(ridePostID,passengerUsername);
	}
	public ArrayList<RidePost> viewUpcomingRides(String username){
		return ridePostTransaction.viewUpcomingRides(username);
	}
	

}

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
	
	//Transaction classes go here? Autowired?
	@Autowired
	RidePostTransaction ridePostTransaction;
	@Autowired
	PassengerRequestTransaction passengerRequestTransaction;
	@Autowired
	UserTransaction userTransaction;
	
	UserTransaction user = new UserTransaction();

	@RequestMapping("/")
	String index() {
		return "index";
	}
	String userID;
	String password;
	@GetMapping("/login")
	public String getLogin() throws ServletException, IOException {

		return "login";
	}
	@PostMapping("/login")
	public String postLogin(HttpServletRequest request, HttpServletResponse response) {
//		request.login(userID, password);
//		userID = request.getParameter("userid");
//		password = request.getParameter("password");
//		System.out.println(userID);
//		user.verifyLogin(userID, password);

		return "home";
	}
	@GetMapping("/home")
	public String getHome() {
		return "home";
		
	}
	@PostMapping("/home")
	public String postHome() {
		return "home";
	}
		
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
	public ArrayList<PassengerRequest> viewPendingRides(String username){
		return passengerRequestTransaction.viewPendingRides(username);
	}
}

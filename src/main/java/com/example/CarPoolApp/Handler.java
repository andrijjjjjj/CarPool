/**
 * 
 */
package com.example.CarPoolApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

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
import org.springframework.web.bind.annotation.GetMapping;


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
	 
	String currentUserID = "sclaus"; //This instantiation is for tests. This variable should be set by calling the login method. Can use this method to determine if a user is logged in(null = not logged in).
	
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
		if(currentUserID == null)//User isn't logged in. Shouldn't be able to access this method/page.
		{
			return "loginpage";
		}
		model.addAttribute("currentUserID", currentUserID); //This allows the html page to access the currentUserID variable. Can put methods in this call too.
		
		return "homepage";
	}
	
	@RequestMapping("/home/viewallrides")//The viewallrides page of the website. Will show all rideposts.
	public String loadViewAllRidesPage(Model model) {
		if(currentUserID == null)//User isn't logged in. Shouldn't be able to access this method/page.
		{
			return "loginpage";
		}
		model.addAttribute("allrideposts", viewAllRides()); //Puts arraylist of all ride posts in html page.
		
		return "homepage";//TODO need to make html page for viewallridespage.html.
	}
	
	@RequestMapping("/favorites")
	public String getFavorites(Model model) {
		if(currentUserID == null)
		{
			return "loginpage";
		}
		model.addAttribute("firstName", userTransaction.getUser(currentUserID).getProfile().getfName());
		
		String myFavorites = "";
		for(int i = 0; i < userTransaction.getUser(currentUserID).getFavorites().size(); i++) {
			myFavorites += userTransaction.getUser(currentUserID).getFavorites().get(i)+"\n";
		}
		model.addAttribute("favorites", myFavorites);
		
		return "favorites";
	}
	
	@RequestMapping("/home/viewallrides/{ridePostID}")//A page for viewing a ridePost. DO WE WANT THIS? OR JUST BUTTON TO MAKE PASSENGER REQUEST ON POST?
	public String loadViewOneRidePostPage(Model model) {//TODO need to add @Param something in parameters for ridePostID.
		if(currentUserID == null)//User isn't logged in. Shouldn't be able to access this method/page.
		{
			return "loginpage";
		}
		//model.addAttribute("ridepost", ridePostTransaction.getRidePost(ridePostID)); //TODO ^^^
		
		return "homepage";//TODO need to make html page for loadviewoneridepostpage.html.
	}
	//TODO Make mappings/pages for all use cases.
	
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
	public ArrayList<PassengerRequest> viewPendingRides(String username){
		return passengerRequestTransaction.viewPendingRides(username);
	}
	public ArrayList<PassengerRequest> viewPassengerRequests(String username, int ridePostID){
		return passengerRequestTransaction.viewPassengerRequests(username, ridePostID);
	}
}

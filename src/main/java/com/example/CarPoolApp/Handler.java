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
	 
	String currentUserID = "Michael"; //This instantiation is for tests. This variable should be set by calling the login method. Can use this method to determine if a user is logged in(null = not logged in).
	
	@RequestMapping("/")//The initial page of the website. Should have buttons for sign-up, login, forgot password.
	public String loadInitialPage() {
		return "welcomepage";
	}
	
	@RequestMapping("/signup")//The sign-up page of the website.
	public String loadSignUpPage() throws ServletException, IOException {

		//User enters in info to all boxes, clicks button. Button calls signup use case method, then redirects to login page.
		return "signuppage";//TODO Make html.
	}
	
	@RequestMapping("/login")//The login page of the website.
	public String loadLoginPage() throws ServletException, IOException {

		return "loginpage";
	}
	
	@RequestMapping("/login/forgotpassword")//The forgot password.
	public String loadForgottenPassword() throws ServletException, IOException {
		//This page will have a form where the user enters their email. Then a button.
		//Once button pressed, send email to that email.
		//In the email, the link should be to a specific page used to set a new password for the account. 
		//The email will also send a verification code to verify that user is who they say they are on the website. //TODO where do we store this in backend? User class?
		
		return "loginpage";//Go back to loginpage page.
	}
	
	@RequestMapping("/login/changeforgotpassword/useraccount")//The change forgot password page.
	public String loadChangeForgottenFassword() throws ServletException, IOException {//TODO need to make @param something to access specific user account.
		//This page will have a form where the user enters their verification code, enters a form their new password, and clicks a button.
		//Once button pressed, if verification code is the same, call the change forgotten password use case method, return to loginpage.
		//If not, change verification code in User class to null, and redirect user back to home. They will have to resend the verification email and repeat the process.
		
		return "loginpage";//Go back to loginpage page.
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
		
		return "viewallrides";//TODO need to make html page for viewallridespage.html.
	}
	
	@RequestMapping("/home/upcomingRides")//The viewallrides page of the website. Will show all rideposts.
	public String viewUpcomingRides(Model model) {
		if(currentUserID == null)//User isn't logged in. Shouldn't be able to access this method/page.
		{
			return "loginpage";
		}
		model.addAttribute("theUpcomingRides", viewUpcomingRides(currentUserID)); //Puts arraylist of all ride posts in html page.
		
		return "upcomingRides";//TODO need to make html page for viewallridespage.html.
	}
	
	
	
	@RequestMapping("/feedback")//The viewallrides page of the website. Will show all rideposts.
	public String viewFeedback(Model model) {
		if(currentUserID == null)//User isn't logged in. Shouldn't be able to access this method/page.
		{
			return "loginpage";
		}
		//model.addAttribute("feedback", viewUpcomingRides(currentUserID)); //Puts arraylist of all ride posts in html page.
		
		return "feedback";//TODO need to make html page for viewallridespage.html.
	}
	
	@RequestMapping("/home/viewallrides/{ridePostID}")//A page for viewing a ridePost. DO WE WANT THIS? OR JUST BUTTON TO MAKE PASSENGER REQUEST ON POST?
	public String loadViewOneRidePostPage(Model model) {//TODO need to add @Param something in parameters for ridePostID.
		if(currentUserID == null)//User isn't logged in. Shouldn't be able to access this method/page.
		{
			return "loginpage";
		}
		//model.addAttribute("ridepost", ridePostTransaction.getRidePost(ridePostID)); //TODO ^^^
		
		return "viewoneridepostpage";//TODO need to make html page for loadviewoneridepostpage.html.
	}
	
	@RequestMapping("/home/viewallrides/makeridepost")//A page for making a ridePost.
	public String loadViewMakeRidePostPage(Model model) {
		if(currentUserID == null)//User isn't logged in. Shouldn't be able to access this method/page.
		{
			return "loginpage";
		}
		//Have button on viewallrides page that when clicked, moves to this page. User will enter info into boxes. Pushes button that calls the make ridepost use case method, then redirects to viewallridepostspage OR viewoneridepostpage.
		
		return "makeridepostpage";//TODO need to make html page for making a ridepost.
	}
	
	@RequestMapping("/home/currentuseraccount")//The account/profile page for the currently logged in user.
	public String loadCurrentUserAccountPage(Model model) {
		if(currentUserID == null)//User isn't logged in. Shouldn't be able to access this method/page.
		{
			return "loginpage";
		}
		model.addAttribute("currentUser", userTransaction.getUser(currentUserID)); //This allows the html page to access the currentUserID variable. Can put methods in this call too.
		
		return "currentuseraccountpage";//TODO Make this html.
	}
	
	@RequestMapping("/home/currentuseraccount/deleteaccountprompt")//The "are you sure" prompt before a user deletes their account. 
	public String loadDeleteAccountPromptPage(Model model) {
		if(currentUserID == null)//User isn't logged in. Shouldn't be able to access this method/page.
		{
			return "loginpage";
		}
		//The user should see a prompt, and a button for yes and no. 
		//If yes is clicked, then the delete account user case method is called, then return to welcome page.
		//If no is clicked, then return to home page OR user account page.
		
		return "currentuseraccountpage";//TODO Make this html.
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

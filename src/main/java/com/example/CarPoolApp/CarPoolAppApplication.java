package com.example.CarPoolApp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class CarPoolAppApplication {

	private static final Logger log = LoggerFactory.getLogger(CarPoolAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarPoolAppApplication.class);
	}

	@Bean
	public CommandLineRunner loadData(UserRepository repository, Handler handleMe, RidePostRepository rideRepo) {
		return (args) -> {
			// save a couple of userAccounts
			repository.save(new User("dolunde", "1s", "David", "Lunde", "Male", "601-554-1234", 1));
			repository.save(new User("rjroof", "lmao", "Ryan", "jack", "Male", "601-584-1154", 0));
			repository.save(new User("Mjdevi1", "1234", "Mike", "christmas", "Male", "601-522-1514", 1));
			repository.save(new User("mj", "m", "Michael", "Reyes", "Male", "911", 1));
			

			// Save a couple of ridePosts
			rideRepo.save(new RidePost(null, "dolunde", "My Home", "End Home", "1998-11-10", "16:05", "My car", "100",
					2, false));
			rideRepo.save(new RidePost(null, "rjroof", "Not my Home", "End Home", "2019-12-10", "17:05", "My car",
					"100", 2, true));
			rideRepo.save(new RidePost(null, "mjdevi1", "Friends Home", "End Home", "2020-12-11", "12:05", "My car",
					"100", 2, false));
			rideRepo.save(new RidePost(null, "dolunde", "My Home Again", "End Home", "2012-10-10", "09:05", "My car",
					"100", 2, true));
			rideRepo.save(new RidePost(null, "dolunde", "My Home Again", "End Home", "2020-10-10", "09:05", "My car",
					"100", 2, true));
			

//			boolean workPlease=handleMe.signUp("Mjdevi1", "1234", "123-456-7890","Clunt", "TheChristmasBlunt","male");
//			System.out.println(workPlease);
//			handleMe.editProfile("Mjdevi1", "630-137-5309", "Dave", "isGay","female");
//			String test=handleMe.deleteUser("Mjdevi1");
//			System.out.println(test);
			// fetch all userAccounts
			log.info("All users listed");
			log.info("-------------------------------");
			for (User userAccount : repository.findAll()) {
				log.info(userAccount.toString());
			}
			log.info("");

			// fetch an individual userAccount by ID
			User userAccount = repository.findById("dolunde").get();
			log.info("User found in database findOne(\"dolunde\"):");
			log.info(userAccount.toString());
			log.info("");

			// Test recieve ride posts in database.
			log.info("All rideposts posted");
			log.info("-------------------------------");
			for (RidePost ride : rideRepo.findAll()) {
				log.info(ride.toString());
			}
			log.info("\n");

			// fetch userAccounts by last name
//			log.info("Username found with adeptdave:");
//			for (User adeptdave : repository.findByUsernameStartsWithIgnoreCase("adeptdave")) {
//				log.info(adeptdave.toString());-
//			}
//			log.info("");
			// Testing Favorites
//			log.info("TESTING FEATURE: Favorites");
//			log.info("--------------------------");
//			user.addToFavorites(user2.getUserID());
//			user.addToFavorites(user3.getUserID());
//			//user.addToFavorites(user2.getUserID());
//			List<String> favorites = user.getFavorites();
//			log.info("User Favorites:");
//			for (String temp : favorites) {
//				System.out.println(temp);
//			}
//			
//			user.removeFromFavorites(user2.getUserID());
//			log.info("User Favorites Updated:");
//			for (String temp : favorites) {
//				System.out.println(temp);
//			}
//			log.info("--------------------------");
//			
//			// Testing Feedback
//			
//			log.info("Ratings:");

//			List<String> comments = user.getProfile().getComments();
//			for (String temp : comments) {
//				System.out.println(temp);
//			}

			// POPULATE WEBPAGE WITH INFORMATION
			User user = new User("dschrute", "beets", "Dwight", "Schrute", "Male", "1234567890", 1);

//			user.getProfile().setRating(5);
//			user.getProfile().setRating(4);
//			user.getProfile().setRating(3);
//			user.getProfile().setRating(2);
//			user.getProfile().setRating(1);
//			user.getProfile().addComment("cool driver");
//			user.getProfile().addComment("bad driver");
//			user.getProfile().addComment("i like this guy");
//			user.getProfile().addComment("this guy sucks");
//			user.addToFavorites("Michael Scott - mscott");
//			user.addToFavorites("Angela Martin - amartin");
//			user.addToFavorites("Jim Halpert - jhalpert");
//			user.addToFavorites("Pam Beesly - pbeesly");
//			user.addToFavorites("Kevin Malone - kmalone");
//			user.addToFavorites("Andy Bernard - abernard");
//			repository.save(user);

			user.getProfile().setRating(1);
			user.getProfile().setRating(2);
			user.getProfile().setRating(3);
			user.getProfile().setRating(4);
			user.getProfile().setRating(5);
			user.getProfile().addComment("Good driver!");
			user.getProfile().addComment("Okay driver!");
			user.getProfile().addComment("Shit driver!");
			user.getProfile().addComment("stupid ass driver!");
			user.getProfile().addComment("i like this driver!");
			user.getProfile().addComment("cool driver");
			repository.save(user);
		};
	}

//	//Testing email notifications.
//	@EventListener(ApplicationReadyEvent.class)
//	public void doSomethingAfterStartup() {
//	    //User user = new User("ULID", "PASSWORD", "FIRSTNAME", "LASTNAME", "GENDER", "PHONENUMBER", INT STATUS);
//		// DEFAULT INT STATUS: 0 (ACTIVE ACCOUNT)
//		// 					   1 (INACTIVE ACCOUNT)
//	    User user = new User("sclaus", "hohoho", "Santa", "Claus", "Male", "1234567890", 0);
//		Email email = new Email();
//		email.emailReminder(user);
//		email.emailPassengerCancelled(user);
//		email.emailRideCancelled(user);
//		email.emailSignUp(user);
//	}
}
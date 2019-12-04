package com.example.CarPoolApp;

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
public class CarPoolAppApplication {
 
	private static final Logger log = LoggerFactory.getLogger(CarPoolAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CarPoolAppApplication.class);
	}

	@Bean
	public CommandLineRunner loadData(UserRepository repository) {
		return (args) -> {
			// save a couple of userAccounts
			repository.save(new User("Nick", "Nose", null, null, null, null, 0));
			repository.save(new User("AdeptDave", "icryeverytim", null, null, null, null, 0));
			repository.save(new User("monkey", "Banyanyas!", null, null, null, null, 0));
			repository.save(new User("cookieMonsta", "cookies", null, null, null, null, 0));
			repository.save(new User("Merry", "christmas", null, null, null, null, 0));
			
			repository.save(new User("David", "PG", null, null, null, null, 0));
			repository.save(new User("Michelle", "Please", null, null, null, null, 0));

			// fetch all userAccounts
			log.info("All users listed");
			log.info("-------------------------------");
			for (User userAccount : repository.findAll()) {
				log.info(userAccount.toString());
			}
			log.info("");

			// fetch an individual userAccount by ID
			User userAccount = repository.findById("Nick").get();
			log.info("User found in database findOne(\"Nick\"):");
			log.info(userAccount.toString());
			log.info("");

			// fetch userAccounts by last name
//			log.info("Username found with adeptdave:");
//			for (User adeptdave : repository.findByUsernameStartsWithIgnoreCase("adeptdave")) {
//				log.info(adeptdave.toString());
//			}
//			log.info("");
		};
	}
	
//	//Testing email notifications.
//	@EventListener(ApplicationReadyEvent.class)
//	public void doSomethingAfterStartup() {
//		// User(String userID, String password, int status, String phoneNumber, String fName, String lName)
//		// userID is ULID
//	    User user = new User("USERID", "PASSWORD", 0, "1234567890", "FIRSTNAME", "LASTNAME");
//		Email email = new Email();
//		email.emailReminder(user);
//		email.emailPassengerCancelled(user);
//		email.emailRideCancelled(user);
//		email.emailSignUp(user);
//	}	
}

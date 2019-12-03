package com.example.CarPoolApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import hello.CarPoolAppApplication;
//import hello.User;
//import hello.UserTransaction;

@SpringBootApplication
public class CarPoolAppApplication {

	private static final Logger log = LoggerFactory.getLogger(CarPoolAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CarPoolAppApplication.class);
	}

	@Bean
	public CommandLineRunner loadData(UserTransaction repository) {
		return (args) -> {
			// save a couple of userAccounts
			repository.save(new User("Dick", "Nose"));
			repository.save(new User("AdeptDave", "icryeverytim"));
			repository.save(new User("monkey", "Banyanyas!"));
			repository.save(new User("cookieMonsta", "cookies"));
			repository.save(new User("CLUNT", "THEchristmas*****"));
			
			repository.save(new User("David", "Palmer"));
			repository.save(new User("Michelle", "Dessler"));

			// fetch all userAccounts
			log.info("All users listed");
			log.info("-------------------------------");
			for (User userAccount : repository.findAll()) {
				log.info(userAccount.toString());
			}
			log.info("");

			// fetch an individual userAccount by ID
			User userAccount = repository.findById(1L).get();
			log.info("User found in database findOne(1L):");
			log.info(userAccount.toString());
			log.info("");

			// fetch userAccounts by last name
			log.info("Username found with adeptdave:");
			for (User adeptdave : repository.findByUsernameStartsWithIgnoreCase("adeptdave")) {
				log.info(adeptdave.toString());
			}
//			log.info("");
		};
	}

}

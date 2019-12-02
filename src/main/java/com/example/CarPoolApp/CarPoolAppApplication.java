package com.example.CarPoolApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarPoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPoolAppApplication.class, args);
	}
	
	//Testing hibernate stuff with logger.
	private static final Logger log = LoggerFactory.getLogger(CarPoolAppApplication.class);
	
//	@Bean
//	  public CommandLineRunner demo(UserTransaction repository) {
//	    return (args) -> {
//	      // save a few users
//	      repository.save(new User("Jack", "Bauer", 4));
//	      repository.save(new User("Chloe", "O'Brian", 7));
//	      repository.save(new User("Kim", "Bauer", 1));
//	      repository.save(new User("David", "Palmer", 3));
//	      repository.save(new User("Michelle", "Dessler", 1));
//
//	      // fetch all users
//	      log.info("Users found with findAll():");
//	      log.info("-------------------------------");
//	      for (User user : repository.findAll()) {
//	        log.info(user.toString());
//	      }
//	      log.info("");
//
//	      // fetch an individual user by ID
//	      User user = repository.findUserByID("Bauer");
//	      log.info("User found with findUserByID(\"Bauer\"):");
//	      log.info("--------------------------------");
//	      log.info(user.toString());
//	      log.info("");
//
//	      // fetch users by status
//	      log.info("Customer found with findListByStatus(3):");
//	      log.info("--------------------------------------------");
//	      repository.findListByStatus(3).forEach(bauer -> {
//	        log.info(bauer.toString());
//	      });
//	      // for (Customer bauer : repository.findByLastName("Bauer")) {
//	      //  log.info(bauer.toString());
//	      // }
//	      log.info("");
//	    };
//	  }

}

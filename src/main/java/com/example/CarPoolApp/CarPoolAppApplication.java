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

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@EnableJpaRepositories("com.pharmacy.persistence.users.dao")
public class CarPoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPoolAppApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    User user = new User("mjreyes", "abc123", 0, "1234567890", "Michael", "Reyes");
		EmailReminder reminder = new EmailReminder(user);
		reminder.email(user);
	}
	
	
	
	//Testing hibernate stuff with logger.
	private static final Logger log = LoggerFactory.getLogger(CarPoolAppApplication.class);
	
	//public User(String userID, String password, int status, String phoneNumber, String fName, String lName)
	
	
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
//	      log.info("");
//	    };
//	  }

}

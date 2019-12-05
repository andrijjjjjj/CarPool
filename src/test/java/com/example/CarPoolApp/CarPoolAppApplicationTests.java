package com.example.CarPoolApp;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(Handler.class)
@TestPropertySource(properties = "logging.level.org.springframework.web=DEBUG")
public class CarPoolAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
//	@Autowired
//	RidePostTransaction ridePostTransaction;
	
	@Autowired
	RidePostRepository ridePostRepository; //TODO PROBABLY SHOULDNT USE. Should use transaction classes OR maybe even handler.
	
//	@Autowired
//	PassengerRequestTransaction passengerRequestTransaction;
	
	@Autowired
	PassengerRequestRepository passengerRequestRepository; //TODO PROBABLY SHOULDNT USE. Should use transaction classes OR maybe even handler.
	
//	@Autowired
//	UserTransaction userTransaction;
	
	@Autowired
	UserRepository userRepository; //TODO PROBABLY SHOULDNT USE. Should use transaction classes OR maybe even handler.

//	@Test
//	public void rendersForm() throws Exception {
//		mockMvc.perform(get("/users"))
//				.andExpect(content().string(containsString("Form")));
//	}
//
//	@Test
//	public void submitsForm() throws Exception {
//		mockMvc.perform(post("/users").param("username", "12345").param("content", "Hello"))
//				.andExpect(content().string(containsString("Result")))
//				.andExpect(content().string(containsString("Username: 12345")));
//	}
//	@Test
//	public void contextLoads() {
//	}
	
	//Junits below here!
	
	@Test
	public void favoriteUser() //Testing Favorite User use case.
	{
		// Testing Favorites
		User user = new User("sclaus", "hohoho", "Santa", "Claus", "Male", "1234567890", 0);
		userRepository.save(user);

		User user2 = new User("sclaus2", "hohoho", "Santa2", "Claus2", "Male", "1234567890", 0);
		userRepository.save(user2);
		User user3 = new User("sclaus3", "hohoho", "Santa3", "Claus3", "Male", "1234567890", 0);
		userRepository.save(user3);

		user.addToFavorites(user2.getUserID());
		user.addToFavorites(user3.getUserID());
		user.addToFavorites(user2.getUserID());
		
		assertEquals(user.getFavorites().get(0), "sclaus2");
		assertEquals(user.getFavorites().get(1), "sclaus3");
		assertEquals(user.getFavorites().get(2), null);
	}
	
	
	
	

}
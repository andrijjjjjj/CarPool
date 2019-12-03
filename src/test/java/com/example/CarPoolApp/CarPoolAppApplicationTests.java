package com.example.CarPoolApp;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.containsString;
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

	@Test
	public void rendersForm() throws Exception {
		mockMvc.perform(get("/users"))
				.andExpect(content().string(containsString("Form")));
	}

	@Test
	public void submitsForm() throws Exception {
		mockMvc.perform(post("/users").param("username", "12345").param("content", "Hello"))
				.andExpect(content().string(containsString("Result")))
				.andExpect(content().string(containsString("Username: 12345")));
	}
	@Test
	void contextLoads() {
	}

}
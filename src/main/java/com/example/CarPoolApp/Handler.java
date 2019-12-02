/**
 * 
 */
package com.example.CarPoolApp;

import java.util.ArrayList;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class Handler {

	@GetMapping("/users")
	public String enterLogin(Model model) {
		model.addAttribute("users", new User());
		return "users";
	}

	@PostMapping("/users")
	public String exitLogin(@ModelAttribute User user) {
		return "result";
	}

}

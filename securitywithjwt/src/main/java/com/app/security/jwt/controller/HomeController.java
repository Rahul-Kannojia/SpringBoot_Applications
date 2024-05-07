package com.app.security.jwt.controller;

//import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.security.jwt.model.User;
import com.app.security.jwt.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/home")
@Log4j2
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUser() {
		log.info("Getting the User Details");
		return this.userService.getUsers();// using this keyword with instance/ reference object is a recommended way
	}

//	@GetMapping("/current-user")
//	public String getCurrentUser(Principal principal) {
//		return principal.getName();
//	}

	@GetMapping(value = "/username")
	public String currentUserName(Authentication authentication) {
		return authentication.getName();
	}

}

package com.app.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringbootController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Springboot: Welcome";
	}
}

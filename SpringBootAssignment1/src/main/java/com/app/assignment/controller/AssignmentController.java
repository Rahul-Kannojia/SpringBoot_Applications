package com.app.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.assignment.service.AssignmentService;

@RestController
public class AssignmentController {
	
	@Autowired
	private AssignmentService assignmentService;

	@GetMapping("/add")
	public Integer addition(int a, int b) {
		
	   return assignmentService.addition(a,b);
	}
}

package com.app.assignment;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.assignment.service.AssignmentService;

@SpringBootTest
class SpringBootAssignment1ApplicationTests {

	@Autowired
	AssignmentService assignmentService;
	
	@Test
	void testAddition() {
		
		int result = assignmentService.addition(5,7);
		Assertions.assertEquals(12, result);
	}

}

package com.app.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.assignment.dao.AssignmentDao;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private AssignmentDao assignmentDao;
	
	@Override
	public Integer addition(int a, int b) {
		int sum = a + b;
		//System.out.println("Sum of two numbers:"+ sum);
		return sum;
	}

}

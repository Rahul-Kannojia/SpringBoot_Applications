package com.app.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springboot.dao.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDAO paymentdao;//PaymentServiceImpl has HAS-A relation with PaymentDAO so we Autowire here.

}

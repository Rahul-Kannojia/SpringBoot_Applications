package com.app.security.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.app.security.jwt.model.User;

@Service
public class UserService {
	
	private List<User> userList = new ArrayList<>();

	public UserService() {
		userList.add(new User(UUID.randomUUID().toString(),"Rahul Kannojia","rk@gmail.com"));
		userList.add(new User(UUID.randomUUID().toString(),"Shweta Rahul Kannojia","shweta@gmail.com"));
		userList.add(new User(UUID.randomUUID().toString(),"Khusi Chadhary","khusi@gmail.com"));
		userList.add(new User(UUID.randomUUID().toString(),"Meera Devi","meeradevi@gmail.com"));	
	}
	
	public List<User> getUsers(){
		return this.userList;
	}
	
	

}

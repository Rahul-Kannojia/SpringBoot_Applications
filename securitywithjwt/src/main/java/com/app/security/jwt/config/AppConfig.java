package com.app.security.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder() ;
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		
		UserDetails user = User.builder().username("rahul").password(passwordEncoder().encode("RahulPass")).roles("ADMIN").build();
		UserDetails user1 = User.builder().username("shweta").password(passwordEncoder().encode("ShwetaPass")).build();
		
		return new InMemoryUserDetailsManager(user,user1);
	}
	
}

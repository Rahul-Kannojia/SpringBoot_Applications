package com.app.security.jwt.security;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			PrintWriter writer = response.getWriter();
			writer.println("Access Denied:"+authException.getLocalizedMessage());
			log.info("Access Denied:"+authException.getLocalizedMessage());
	}

}

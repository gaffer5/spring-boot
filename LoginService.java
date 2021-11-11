package com.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;

// Spring Bean
@Component
public class LoginService {
	public boolean validateUser(String userId, String password) {
		// (Stephen, dream)
		return userId.equalsIgnoreCase("Stephen")
				&& password.equalsIgnoreCase("dream");
	}

}

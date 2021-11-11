package com.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.web.springbootfirstwebapplication.service.LoginService;


// /login => Hello World
@Controller
public class LoginController {
	// Inject Automatically
	@Autowired
	LoginService service;
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		//model.put("name", name);
		return "login"; 
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String ShowWelcomePage(ModelMap model, @RequestParam String name, String password){
		boolean isValidUser = service.validateUser(name, password);
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("name", name);
		return "welcome"; 
	}
 
}

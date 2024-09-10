package com.capg.payment_wallet_application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.payment_wallet_application.beans.Customer;
import com.capg.payment_wallet_application.dto.CustomerDTO;
import com.capg.payment_wallet_application.service.IUserService;

/*
 * Controller Name          : User Controller
 * Author                   : Rishi Kiran
 * Implementation Start Date: 2021-04-06
 * implementation End Date  : 2021-04-07
 * Used Annotation          : @RestController,@RequestMapping,@Autowired,@GetMapping
 * Swagger                  : Swagger is enabled
 * */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pwa/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	//Validates the user login credentials and returns a CustomerDTO if credentials are correct
	@PutMapping("/validate")
	public CustomerDTO validateLogin(@RequestBody Customer customer) {
		logger.info("Login is done sucessfully");
		return userService.validateLogin(customer.getMobileNo(), customer.getPassword());
	}
}

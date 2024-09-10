package com.capg.payment_wallet_application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.payment_wallet_application.beans.Customer;
import com.capg.payment_wallet_application.dto.CustomerDTO;
import com.capg.payment_wallet_application.exception.InvalidInputException;
import com.capg.payment_wallet_application.repo.IUserRepo;
import com.capg.payment_wallet_application.util.CustomerUtils;

/*
 * Implemented Service Name : User Service
 * Author                   : Rishi Kiran
 * Implementation Start Date: 2021-04-05
 * implementation End Date  : 2021-04-06
 * Used Annotation          : @Service,@Autowired,@Override
 * Validation               : Validation are done at Required Place
 * */
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepo userRepo;

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public CustomerDTO validateLogin(String mobileNumber, String password) {
		logger.info("validateLogin() is get intiated");
		password = Integer.valueOf(password.hashCode()).toString();
		Customer customer = userRepo.validateLogin(mobileNumber, password);
		logger.info(password);
		if (customer == null) {
			throw new InvalidInputException("Wrong Credentials");
		} else {
			logger.info("validateLogin() is get executed");
			return CustomerUtils.convertToCustomerDto(customer);
		}
	}

}

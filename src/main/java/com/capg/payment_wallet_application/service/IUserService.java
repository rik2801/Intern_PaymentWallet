package com.capg.payment_wallet_application.service;

import com.capg.payment_wallet_application.dto.CustomerDTO;

public interface IUserService {

	public CustomerDTO validateLogin(String mobileNumber, String password);
}

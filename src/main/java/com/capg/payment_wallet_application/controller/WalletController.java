package com.capg.payment_wallet_application.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.payment_wallet_application.beans.Customer;
import com.capg.payment_wallet_application.dto.CustomerDTO;
import com.capg.payment_wallet_application.service.WalletService;

/*
 * Controller Name          : Wallet Controller
 * Author                   : Arun Kumar M
 * Implementation Start Date: 2021-04-06
 * implementation End Date  : 2021-04-07
 * Used Annotation          : @RestController,@RequestMapping,@Autowired,@PostMapping,@GetMapping,@PutMapping
 * Swagger                  : Swagger is enabled
 * */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pwa/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	// Controller for adding a new customer with a wallet
	@PostMapping("/create-account")
	public CustomerDTO createAccount(@RequestBody Customer customer) {
		logger.info("Customer profile is created sucessfully");
		return walletService.createAccount(customer);
	}

	// Controller for fetching a customer object with its wallet balance
	@GetMapping("/show-balance/{mobileno}")
	public CustomerDTO showBalance(@PathVariable String mobileno) {
		logger.info("Balance of the given mobile number is displayed");
		return walletService.showBalance(mobileno);
	}

	// Controller for sending money from one customer to another using their mobile
	// numbers
	@PutMapping("/fund-transfer/{sourceMobileNo}/{targetMobileNo}/{amount}")
	public CustomerDTO fundTransfer(@PathVariable String sourceMobileNo, @PathVariable String targetMobileNo,
			@PathVariable BigDecimal amount) {
		logger.info("Fund transfer and transaction between source and target");
		return walletService.fundTransfer(sourceMobileNo, targetMobileNo, amount);
	}

	// Controller for depositing amount into the wallet
	@PutMapping("/deposit-amount/{mobileNo}/{amount}")
	public CustomerDTO depositAmount(@PathVariable String mobileNo, @PathVariable BigDecimal amount) {
		logger.info("The amount is deposited in the wallet of given mobilenumber");
		return walletService.depositAmount(mobileNo, amount);
	}

	// Controller for withdrawing money from the wallet
	@PutMapping("/withdraw-amount/{mobileNo}/{amount}")
	public CustomerDTO withdrawAmount(@PathVariable String mobileNo, @PathVariable BigDecimal amount) {
		logger.info("The amount is withdraw from the wallet of given mobilenumber");
		return walletService.withdrawAmount(mobileNo, amount);
	}

	// Controller for getting the list of all the customers
	@GetMapping("/get-list")
	public List<CustomerDTO> getList() {
		logger.info("The List of customer is displayed");
		return walletService.getList();
	}

	// Controller to update the customer details
	@PutMapping("/update-account")
	public CustomerDTO updateAccount(@RequestBody Customer customer) {
		logger.info("The customer profile is updated");
		return walletService.updateAccount(customer);
	}

	// Controller for adding money into the wallet from bank account
	@PutMapping("/add-money/{walletId}/{amount}")
	public CustomerDTO addMoney(@PathVariable int walletId, @PathVariable double amount) {
		logger.info("The money is added into wallet");
		return walletService.addMoney(walletId, amount);
	}

}
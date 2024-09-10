package com.capg.payment_wallet_application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.payment_wallet_application.beans.BankAccount;
import com.capg.payment_wallet_application.dto.BankAccountDTO;
import com.capg.payment_wallet_application.dto.WalletDTO;
import com.capg.payment_wallet_application.service.AccountServiceImpl;
/*
 * Controller Name          : AccountController
 * Author                   : S. Eswar Bhavish Reddy
 * Implementation Start Date: 2021-04-06
 * implementation End Date  : 2021-04-07
 * Used Annotation          : @RestController, @RequestMapping, @Autowired, @PostMapping, @GetMapping, @DeleteMapping
 * Swagger                  : Swagger is enabled
 * Description				: Controller layer for Account
 * */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pwa/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accountService;
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/* Author       : S. Eswar Bhavish Reddy
	*  Description  : Adds BankAccount to the Wallet
	*  Input Param  : BankAccount
	*  Return value : WalletDTO Object
	*/
	@PostMapping("/add")
	public WalletDTO addAccount(@RequestBody BankAccount bankAccount) {
		logger.info("Account added succesfully");
		return accountService.addAccount(bankAccount);
	}
	
	/* Author       : S. Eswar Bhavish Reddy
	*  Description  : Removed account from Wallet
	*  Input Param  : BankAccount
	*  Return value : WalletDTO Object
	*/
	@DeleteMapping("/remove")
	public WalletDTO removeAccount(@RequestBody BankAccount bankAccount) {
		logger.info("Account removed");
		return accountService.removeAccount(bankAccount);
	}

	/* Author       : S. Eswar Bhavish Reddy
	*  Description  : Views Wallet related to account
	*  Input Params : int, String
	*  Return value : WalletDTO Object
	*/
	@GetMapping("/view/{accountNo}/{ifscCode}")
	public WalletDTO viewAccount(@PathVariable long accountNo,@PathVariable String ifscCode) {
		logger.info("wallet for the account fetched");
		return accountService.viewAccount(accountNo,ifscCode);
	}
	
	/* Author       : S. Eswar Bhavish Reddy
	*  Description  : view all accounts linked with the wallet
	*  Input Param  : int
	*  Return value : List of BankAccount DTO
	*/
	@GetMapping("/viewAll/{walletId}")
	public List<BankAccountDTO> viewAllAccounts(@PathVariable int walletId) {
		logger.info("all accounts linked with the wallet are fetched");
		return accountService.viewAllAccounts(walletId);


	}

}

package com.capg.payment_wallet_application.service;

import java.math.BigDecimal;
import java.util.List;

import com.capg.payment_wallet_application.beans.Customer;
import com.capg.payment_wallet_application.dto.CustomerDTO;

public interface WalletService {
	public CustomerDTO createAccount(Customer customer);

	public CustomerDTO showBalance(String mobileno);

	public CustomerDTO fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount);

	public CustomerDTO depositAmount(String mobileNo, BigDecimal amount);

	public CustomerDTO withdrawAmount(String mobileNo, BigDecimal amount);

	public List<CustomerDTO> getList();

	public CustomerDTO updateAccount(Customer customer);

	public CustomerDTO addMoney(int walletId, double amount);

}

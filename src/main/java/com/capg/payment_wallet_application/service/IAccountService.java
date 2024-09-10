package com.capg.payment_wallet_application.service;

import java.util.List;

import com.capg.payment_wallet_application.beans.BankAccount;
import com.capg.payment_wallet_application.dto.BankAccountDTO;
import com.capg.payment_wallet_application.dto.WalletDTO;
/*
 * Interface Name           : IAccountService
 * Author                   : S. Eswar Bhavish Reddy
 * Implementation Start Date: 2021-04-05
 * implementation End Date  : 2021-04-06
 * Description				: Service Layer interface for AccountServiceImpl
 * */
public interface IAccountService {

	public WalletDTO addAccount(BankAccount bacc);

	public WalletDTO removeAccount(BankAccount bacc);

	public List<BankAccountDTO> viewAllAccounts(int walletId);

	WalletDTO viewAccount(long accountNo, String ifscCode);

}

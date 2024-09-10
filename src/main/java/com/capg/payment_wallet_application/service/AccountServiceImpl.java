package com.capg.payment_wallet_application.service;

import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.payment_wallet_application.beans.AccountId;
import com.capg.payment_wallet_application.beans.BankAccount;
import com.capg.payment_wallet_application.beans.Customer;
import com.capg.payment_wallet_application.beans.Wallet;
import com.capg.payment_wallet_application.dto.BankAccountDTO;
import com.capg.payment_wallet_application.dto.WalletDTO;
import com.capg.payment_wallet_application.exception.InvalidInputException;
import com.capg.payment_wallet_application.exception.WalletNotFoundException;
import com.capg.payment_wallet_application.repo.IAccountRepository;
import com.capg.payment_wallet_application.repo.WalletRepo;
import com.capg.payment_wallet_application.util.AccountUtils;
import com.capg.payment_wallet_application.util.WalletUtils;
/*
 * Service Name			    : Account Service
 * Author                   : S. Eswar Bhavish Reddy
 * Implementation Start Date: 2021-04-05
 * implementation End Date  : 2021-04-06
 * Used Annotation          : @Service,@Autowired,@Override
 * Validation               : Validations are done as and when required
 * Description				: Service Layer for Account
 * */
@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountRepository accountRepo;

	@Autowired
	private WalletRepo walletRepo;

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/* Author       : S. Eswar Bhavish Reddy
	*  Description  : Add Account to the wallet
	*  Input Param  : BankAccount
	*  Return value : WalletDTO Object
	*/
	@Override
	public WalletDTO addAccount(BankAccount bankAccount) {
		logger.info("addAccount() is get intiated");
		accountRepo.save(bankAccount);
		Wallet wallet = bankAccount.getWallet();
		logger.info("addAccount() is get executed");
		return WalletUtils.convertToWalletDto(wallet);
	}
	
	/* Author       : S. Eswar Bhavish Reddy
	*  Description  : Removed account from Wallet
	*  Input Param  : BankAccount
	*  Return value : WalletDTO Object
	*  Exception	: InvalidInputException
	*/
	@Override
	public WalletDTO removeAccount(BankAccount bankAccount) {
		logger.info("removeAccount() is get intiated");
		AccountId id = new AccountId(bankAccount.getAccountNo(), bankAccount.getIfscCode());
		accountRepo.findById(id).orElseThrow(() -> new InvalidInputException("Given Account no is not present"));
		Wallet wallet = bankAccount.getWallet();
		accountRepo.delete(bankAccount);
		logger.info("removeAccount() is get exectued");
		return WalletUtils.convertToWalletDto(wallet);
	}
	
	/* Author       : S. Eswar Bhavish Reddy
	*  Description  : View All accounts linked with the given walletId
	*  Input Param  : int
	*  Return value : List of BankAccountDTO Objects
	*  Exception	: WalletNotFoundException
	*/
	@Override
	public List<BankAccountDTO> viewAllAccounts(int walletId) {
		logger.info("viewAllAccounts() is get intiated");
		Customer wallet = walletRepo.findByWalletId(walletId);
		if (wallet != null) {
			List<BankAccount> bankAccountList = accountRepo.findByWalletId(walletId);
			logger.info("viewAllAccounts() is get executed");
			return AccountUtils.convertToBankAccountDtoList(bankAccountList);
		} else {
			throw new WalletNotFoundException("Given wallet is not found");
		}
	}
	
	/* Author       : S. Eswar Bhavish Reddy
	*  Description  : Views wallet linked with given accountNo and ifscCode
	*  Input Params : int, String
	*  Return value : WalletDTO Object
	*  Exception	: InvalidInputException
	*/
	@Override
	public WalletDTO viewAccount(long accountNo, String ifscCode) {
		logger.info("viewAccount() is get intiated");
		if (!validateIfscCode(ifscCode)) {
			throw new InvalidInputException(
					"IFSC code must have 4 alphabets followed by 7 numbers total 11 characters");
		}
		AccountId id = new AccountId(accountNo, ifscCode);
		BankAccount bankAccount = accountRepo.findById(id).orElseThrow(()->new InvalidInputException("Wrong credentials"));
		Wallet wallet = bankAccount.getWallet();
		logger.info("viewAccount() is get executed");
		return WalletUtils.convertToWalletDto(wallet);
	}

	/* Author       : S. Eswar Bhavish Reddy
	*  Description  : Method to validate IFSC code given by customer
	*  Input Param  : String
	*  Return value : boolean
	*/
	private boolean validateIfscCode(String ifscCode) {
		logger.info("validateIfscCode() validation is start intiated");
		boolean flag = true;
		if (!Pattern.matches("^[A-Z]{4}[0-9]{7}$", ifscCode)) {
			flag = false;
		}
		logger.info("validateIfscCode() validation is  get executed");
		return flag;
	}
}

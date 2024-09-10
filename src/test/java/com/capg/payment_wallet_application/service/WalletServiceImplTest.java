package com.capg.payment_wallet_application.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import com.capg.payment_wallet_application.beans.BankAccount;
import com.capg.payment_wallet_application.beans.BeneficiaryDetails;
import com.capg.payment_wallet_application.beans.Customer;
import com.capg.payment_wallet_application.beans.Transaction;
import com.capg.payment_wallet_application.dto.CustomerDTO;
import com.capg.payment_wallet_application.exception.InsufficientBalanceException;
import com.capg.payment_wallet_application.exception.InvalidInputException;
import com.capg.payment_wallet_application.util.BeneficiaryDetailsUtils;
import com.capg.payment_wallet_application.util.TransactionUtils;
import com.capg.payment_wallet_application.util.WalletUtils;

import java.util.List;

@Disabled
@SpringBootTest
class WalletServiceImplTest {
	
//	@Autowired
//	private WalletServiceImpl walletService;
//	
//	@Autowired
//	private TransactionService transactionService;
//	
//	@Autowired
//	private BeneficiaryService beneficiaryService;
//	
//	@Autowired
//	private AccountServiceImpl accountService;
//	
//	final Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	@Test
//	void testCreateAccount() {
//		logger.info("testCreateAccount() is get intiated");
//		BigDecimal amount = new BigDecimal(10000), amount1 = new BigDecimal(0);
//		String name = "Arun Kumar", name1 = "Arun Kumar1";
//		String mobileNo = "9876543210", mobileNo1 = "9876543211", mobileNo2 = "9876543212",
//				mobileNo3 = "9876543213",mobileNo4 = "98765432101", mobileNo5 = "987654321a";
//		String password = "Arun@2000", password1 = "Arun2000";
//		
//		CustomerDTO createAccount = walletService.createAccount(name,mobileNo,amount,password);
//		assertTrue(name.equals(createAccount.getName()));
//		assertTrue(mobileNo.equals(createAccount.getMobileNo()));
//		assertEquals(amount,createAccount.getWalletDto().getBalance());
//		assertNotNull(createAccount);
//		
//		assertThrows(InvalidInputException.class, 
//				()->walletService.createAccount(name,mobileNo,amount,password));
//		assertThrows(TransactionSystemException.class, 
//				()->walletService.createAccount(name1,mobileNo1,amount,password));
//		assertThrows(InsufficientBalanceException.class, 
//				()->walletService.createAccount(name,mobileNo2,amount1,password));
//		assertThrows(InvalidInputException.class, 
//				()->walletService.createAccount(name,mobileNo3,amount,password1));
//		assertThrows(TransactionSystemException.class, 
//				()->walletService.createAccount(name,mobileNo4,amount,password));
//		assertThrows(TransactionSystemException.class, 
//				()->walletService.createAccount(name,mobileNo5,amount,password));
//		logger.info("testCreateAccount() is get executed");
//	}
//
//	@Test
//	void testShowBalance() {
//		logger.info("testShowBalance() is get intialized");
//		walletService.createAccount("Arun Kumar M","8765432190",new BigDecimal(1000),"Arun@2000");
//		
//		String mobileNo = "8765432190", mobileNo1 = "8765432191", 
//				mobileNo2 = "98765432101", mobileNo3 = "984229186a";
//		
//		CustomerDTO balance = walletService.showBalance(mobileNo);
//		assertNotNull(balance);
//		assertTrue(mobileNo.equals(balance.getMobileNo()));
//		
//		assertThrows(InvalidInputException.class, ()->walletService.showBalance(mobileNo1));
//		assertThrows(InvalidInputException.class, ()->walletService.showBalance(mobileNo2));
//		assertThrows(InvalidInputException.class, ()->walletService.showBalance(mobileNo3));
//		logger.info("testShowbalance() is get executed");
//	}
//
//	@Test
//	void testFundTransfer() {
//		logger.info("testFundTransfer() is get intiated");
//		walletService.createAccount("Arun Kumar M","7654321980",new BigDecimal(1000),"Arun@2000");
//		walletService.createAccount("Madhuri","7654321981",new BigDecimal(1000),"Madhuri@2000");
//		
//		BigDecimal amount = new BigDecimal(100), amount1 = new BigDecimal(-1);
//		String sourceMobileNo = "7654321980", sourceMobileNo1 = "765432198a"; 
//		String targetMobileNo = "7654321981", targetMobileNo1 = "765432198b";
//		
//		BigDecimal sourceOldBalance = walletService.showBalance(sourceMobileNo).getWalletDto().getBalance();
//		BigDecimal targetOldBalance = walletService.showBalance(targetMobileNo).getWalletDto().getBalance();
//		CustomerDTO balance = walletService.fundTransfer(sourceMobileNo,targetMobileNo,amount);
//		BigDecimal sourceNewBalance = walletService.showBalance(sourceMobileNo).getWalletDto().getBalance();
//		BigDecimal targetNewBalance = walletService.showBalance(targetMobileNo).getWalletDto().getBalance();
//		Transaction sourceTransaction = 
//				new Transaction("SEND",LocalDate.now(),
//						WalletUtils.convertToWallet(walletService.showBalance(sourceMobileNo).getWalletDto()),
//						Double.parseDouble(amount.toString()),
//						"Sending "+amount+" to "+targetMobileNo);
//		Transaction targetTransaction = 
//				new Transaction("RECEIVE",LocalDate.now(),
//						WalletUtils.convertToWallet(walletService.showBalance(targetMobileNo).getWalletDto()),
//						Double.parseDouble(amount.toString()),
//						"Receiving "+amount+" from "+sourceMobileNo);
//		BeneficiaryDetails beneficiary = 
//				new BeneficiaryDetails(
//						walletService.showBalance(targetMobileNo).getName(),
//						walletService.showBalance(targetMobileNo).getMobileNo());
//		beneficiary.setWallet(WalletUtils.convertToWallet(walletService.showBalance(sourceMobileNo).getWalletDto()));
//		Transaction sourceTransaction1 = TransactionUtils.convertToTransaction(transactionService.viewAllTransactions(
//				walletService.showBalance(sourceMobileNo).getWalletDto().getWalletId()).get(0));
//		Transaction targetTransaction1 = TransactionUtils.convertToTransaction(transactionService.viewAllTransactions(
//				walletService.showBalance(targetMobileNo).getWalletDto().getWalletId()).get(0));
//		BeneficiaryDetails beneficiary1 = 
//				BeneficiaryDetailsUtils.convertToBeneficiaryDetails(beneficiaryService.viewBeneficiary(targetMobileNo));
//		
//		assertNotNull(balance);
//		assertTrue(sourceOldBalance.subtract(amount).compareTo(sourceNewBalance)==0);
//		assertTrue(targetOldBalance.add(amount).compareTo(targetNewBalance)==0);
//		assertTrue(sourceTransaction.getTransactionType().equals(sourceTransaction1.getTransactionType()));
//		assertTrue(targetTransaction.getTransactionType().equals(targetTransaction1.getTransactionType()));
//		assertEquals(sourceTransaction.getTransactionDate(),sourceTransaction1.getTransactionDate());
//		assertEquals(targetTransaction.getTransactionDate(),targetTransaction1.getTransactionDate());
//		assertEquals(beneficiary.getName(),beneficiary1.getName());
//		assertEquals(beneficiary.getMobileNo(),beneficiary1.getMobileNo());
//		assertEquals(beneficiary.getWallet().getWalletId(),beneficiary1.getWallet().getWalletId());
//		
//		assertThrows(InvalidInputException.class,()->walletService.fundTransfer(sourceMobileNo1,targetMobileNo,amount));
//		assertThrows(InvalidInputException.class,()->walletService.fundTransfer(sourceMobileNo,targetMobileNo1,amount));
//		assertThrows(InsufficientBalanceException.class,()->walletService.fundTransfer(sourceMobileNo,targetMobileNo,amount1));
//		logger.info("testFundTransfer() is get executed");
//	}
//
//	@Test
//	void testDepositAmount() {
//		logger.info("testDepositAmount() is get intiated");
//		walletService.createAccount("Arun Kumar M", "6543219870", new BigDecimal(1000), "Arun@2000");
//		
//		BigDecimal amount = new BigDecimal(10000), amount1 = new BigDecimal(0);
//		String mobileNo = "6543219870", mobileNo1 = "65432198701", mobileNo2 = "654321987a";
//		
//		BigDecimal oldBalance = walletService.showBalance(mobileNo).getWalletDto().getBalance();
//		CustomerDTO balance = walletService.depositAmount(mobileNo,amount);
//		BigDecimal newBalance = walletService.showBalance(mobileNo).getWalletDto().getBalance();
//		assertNotNull(balance);
//		assertEquals(oldBalance.add(amount),newBalance);
//		
//		assertThrows(InvalidInputException.class, ()->walletService.depositAmount(mobileNo1,amount));
//		assertThrows(InvalidInputException.class, ()->walletService.depositAmount(mobileNo2,amount));
//		assertThrows(InvalidInputException.class, ()->walletService.depositAmount(mobileNo,amount1));
//		logger.info("testDepositAmount() is get executed");
//	}
//
//	@Test
//	void testWithdrawAmount() {
//		logger.info("testWithdrawAmount() is get intiated");
//		walletService.createAccount("Arun Kumar M", "9987654321", new BigDecimal(1000), "Arun@2000");
//		
//		BigDecimal amount = new BigDecimal(500), amount1 = new BigDecimal(0), amount2 = new BigDecimal(5000);
//		String mobileNo = "9987654321", mobileNo1 = "99876543211", mobileNo2 = "998765432a";
//		
//		BigDecimal oldBalance = walletService.showBalance(mobileNo).getWalletDto().getBalance();
//		CustomerDTO balance = walletService.withdrawAmount(mobileNo,amount);
//		BigDecimal newBalance = walletService.showBalance(mobileNo).getWalletDto().getBalance();
//		assertNotNull(balance);
//		assertEquals(oldBalance.subtract(amount),newBalance);
//		
//		assertThrows(InvalidInputException.class, ()->walletService.withdrawAmount(mobileNo1, amount));
//		assertThrows(InvalidInputException.class, ()->walletService.withdrawAmount(mobileNo2, amount));
//		assertThrows(InvalidInputException.class, ()->walletService.withdrawAmount(mobileNo, amount1));
//		assertThrows(InsufficientBalanceException.class, ()->walletService.withdrawAmount(mobileNo, amount2));
//		logger.info("testWithdrawAmount() is get executed");
//	}
//
//	@Test
//	void testGetList() {
//		logger.info("testGetList() is get intiated");
//		walletService.createAccount("Arun Kumar", "8876543210", new BigDecimal(1000), "Arun@2000");
//		
//		List<CustomerDTO> list = walletService.getList();
//		assertNotNull(list);
//		assertDoesNotThrow(()->walletService.getList());
//		logger.info("testGetList() is get executed");
//	}
//
//	@Test
//	void testUpdateAccount() {
//		logger.info("testUpdateAccount() is get intiated");
//		walletService.createAccount("Arun Kumar M", "7765432190", new BigDecimal(1000), "Arun@2000");
//		
//		String name = "Arun Kumar M", name1 = "Arun Kumar 1";
//		String mobileNo = "7765432190", mobileNo1 = "7765432191", mobileNo2 = "776543219a";
//		String password = "Arun@2000", password1 = "Arun2000";
//		BigDecimal amount = new BigDecimal(1500), amount1 = new BigDecimal(0);
//		
//		Customer customer = new Customer(name,mobileNo,password);
//		customer.getWallet().setBalance(amount);
//		CustomerDTO update = walletService.updateAccount(customer);
//		assertNotNull(update);
//		assertTrue(update.getName().equals(name));
//		assertTrue(update.getWalletDto().getBalance().compareTo(amount)==0);
//		
//		Customer customer1 = new Customer(name1,mobileNo,password);
//		customer1.getWallet().setBalance(amount);
//		assertThrows(TransactionSystemException.class, ()->walletService.updateAccount(customer1));
//		Customer customer2 = new Customer(name,mobileNo,password);
//		customer2.getWallet().setBalance(amount1);
//		assertThrows(InsufficientBalanceException.class, ()->walletService.updateAccount(customer2));
//		Customer customer3 = new Customer(name,mobileNo,password1);
//		customer3.getWallet().setBalance(amount);
//		assertThrows(InvalidInputException.class, ()->walletService.updateAccount(customer3));
//		Customer customer4 = new Customer(name,mobileNo1,password);
//		customer4.getWallet().setBalance(amount);
//		assertThrows(InvalidInputException.class,()->walletService.updateAccount(customer4));
//		Customer customer5 = new Customer(name,mobileNo2,password);
//		customer5.getWallet().setBalance(amount);
//		assertThrows(InvalidInputException.class, ()->walletService.updateAccount(customer5));
//		logger.info("testUpdateAccount() is get executed");
//	}
//
//	@Test
//	void testAddMoney() {
//		logger.info("testaddMoney() is get intialized");
//		CustomerDTO customerDto = walletService.createAccount("Arun Kumar M", "6654321980", new BigDecimal(1000), "Arun@2000");
//		BankAccount bankAccount = new BankAccount(1001,"SBIN0000123", "State Bank", 100000, WalletUtils.convertToWallet(customerDto.getWalletDto()));
//		accountService.addAccount(bankAccount);
//		
//		Double amount = 2000.0, amount1 = 0.0;
//		int walletId = walletService.showBalance("6654321980").getWalletDto().getWalletId(), walletId1 = 99;
//		
//		BigDecimal oldBalance = walletService.showBalance("6654321980").getWalletDto().getBalance();
//		double oldBankBalance = accountService.viewAllAccounts(walletId).get(0).getBalance();
//		CustomerDTO addMoney = walletService.addMoney(walletId, amount);
//		BigDecimal newBalance = walletService.showBalance("6654321980").getWalletDto().getBalance();
//		double newBankBalance = accountService.viewAllAccounts(walletId).get(0).getBalance();
//		assertNotNull(addMoney);
//		assertTrue(oldBalance.add(BigDecimal.valueOf(amount)).compareTo(newBalance)==0);
//		assertEquals(oldBankBalance-amount,newBankBalance);
//		
//		assertThrows(InvalidInputException.class,()->walletService.addMoney(walletId, amount1));
//		assertThrows(NullPointerException.class,()->walletService.addMoney(walletId1, amount));
//		logger.info("testaddMoney() is get executed");
//	}

}

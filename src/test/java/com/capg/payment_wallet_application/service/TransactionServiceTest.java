package com.capg.payment_wallet_application.service;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import com.capg.payment_wallet_application.beans.Transaction;
import com.capg.payment_wallet_application.beans.Wallet;
import com.capg.payment_wallet_application.dto.CustomerDTO;
import com.capg.payment_wallet_application.dto.TransactionDTO;
import com.capg.payment_wallet_application.exception.InsufficientBalanceException;
import com.capg.payment_wallet_application.exception.InvalidInputException;
import com.capg.payment_wallet_application.exception.WalletNotFoundException;
import com.capg.payment_wallet_application.util.WalletUtils;
@Disabled
@SpringBootTest
class TransactionServiceTest {

//	@Autowired
//	private TransactionService transactionService;
//
//	@Autowired
//	private WalletServiceImpl walletService;
//	
//	final Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	@Test
//	void testAddTransaction() {
//	    logger.info("testAddTransaction() is intialized");
//		CustomerDTO customer = walletService.createAccount("Deepan Chakravarthy", "9360043198", new BigDecimal(10000), "Deepan@2000");
//		Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		LocalDate Date = LocalDate.parse("2020-08-01");
//		double amount = 5000;
//		double amount1 = 11000;
//		double amount2 = 0;
//		BigDecimal balance = wallet.getBalance();
//		Transaction tran = new Transaction("SEND",Date,wallet,amount,"String");
//		TransactionDTO transaction = transactionService.addTransaction(tran);
//		BigDecimal updatedAmount = BigDecimal.valueOf(amount);
//		BigDecimal updatedBalance = balance.subtract(updatedAmount);
//		assertTrue(tran.getTransactionType().equals(transaction.getTransactionType()));
//		assertEquals(updatedBalance,transaction.getWalletDto().getBalance());
//		assertNotNull(transaction);
//		
//		Transaction tran1 = new Transaction("RECEIVE",Date,wallet,amount,"String");
//		TransactionDTO transaction1 = transactionService.addTransaction(tran1);
//		BigDecimal updatedAmount1 = BigDecimal.valueOf(amount);
//		BigDecimal balance1= transaction.getWalletDto().getBalance();
//		BigDecimal updatedBalance1 = balance1.add(updatedAmount1);
//		assertTrue(tran1.getTransactionType().equals(transaction1.getTransactionType()));
//		assertEquals(updatedBalance1,transaction1.getWalletDto().getBalance());
//		assertNotNull(transaction1);
//		
//		Transaction tran2 = new Transaction("SEND",Date,wallet,amount1,"String");
//		assertThrows(InsufficientBalanceException.class, () -> transactionService.addTransaction(tran2));
//		Transaction tran3 = new Transaction("SEND",Date,wallet,amount2,"String");
//		assertThrows(TransactionSystemException.class, () -> transactionService.addTransaction(tran3));	
//		Transaction tran4 = new Transaction("SEN",Date,wallet,amount2,"String");
//		assertThrows(InvalidInputException.class, () -> transactionService.addTransaction(tran4));
//		logger.info("testAddTransaction() is executed");
//	}
//	@Test
//	void testViewAllTransactionsWallet() {
//		logger.info("testViewAlltransactionsWallet() is intiated");
//		CustomerDTO customer = walletService.createAccount("Deepan Chakravarthy","9894010016", new BigDecimal(10000), "Deepan@2000");
//		Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		double amount = 3000;
//		LocalDate Date = LocalDate.parse("2020-08-01");
//		Transaction tran = new Transaction("SEND",Date,wallet,amount,"String");
//		TransactionDTO transaction = transactionService.addTransaction(tran);
//		int walletId = transaction.getWalletDto().getWalletId();
//		int walletId1=2000;
//		List<TransactionDTO> tran1 = transactionService.viewAllTransactions(walletId);
//		assertDoesNotThrow(()->transactionService.viewAllTransactions(walletId));
//		assertThrows(WalletNotFoundException.class,()->transactionService.viewAllTransactions(walletId1));
//		assertNotNull(tran1);
//		logger.info("testViewAlltransactionWallet() is executed");
//	}
//
//	@Test
//	void testViewAllTransactionsString() {
//		logger.info("testViewAllTransacationsString() is intiated");
//		CustomerDTO customer = walletService.createAccount("Deepan Chakravarthy", "9839012306", new BigDecimal(10000), "Deepan@2000");
//		Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		double amount = 3000;
//		LocalDate Date = LocalDate.parse("2020-08-01");
//		Transaction tran = new Transaction("SEND",Date,wallet,amount,"String");
//		TransactionDTO transaction = transactionService.addTransaction(tran);
//		String transactionType = transaction.getTransactionType();
//		String transactionType2 = "Null";
//		List<TransactionDTO> tran1 = transactionService.viewAllTransactions(transactionType);
//		assertDoesNotThrow(() -> transactionService.viewAllTransactions(transactionType));
//		assertNotNull(tran1);
//		
//		Transaction tran2 = new Transaction("RECEIVE",Date,wallet,amount,"String");
//		TransactionDTO transaction2 = transactionService.addTransaction(tran2);
//		String transactionType1 = transaction2.getTransactionType();
//		List<TransactionDTO> tran3 = transactionService.viewAllTransactions(transactionType);
//		assertDoesNotThrow(() -> transactionService.viewAllTransactions(transactionType1));
//		assertNotNull(tran3);
//		
//		assertThrows(InvalidInputException.class, () -> transactionService.viewAllTransactions(transactionType2));
//		logger.info("testViewAllTransacationsString() is executed");
//	}
//
//	@Test
//	void testViewTransactionsByDate() {
//		logger.info("testViewTransactionByDate() is intiated");
//		CustomerDTO customer1 = walletService.createAccount("Deepan Chakravarthy", "9840091135", new BigDecimal(10000), "Deepan@2000");
//		Wallet wallet1 = WalletUtils.convertToWallet(customer1.getWalletDto());
//		double amount1 = 3000;
//		LocalDate Date1 = LocalDate.parse("2020-08-01");
//		Transaction tran = new Transaction("SEND",Date1,wallet1,amount1,"String");
//		transactionService.addTransaction(tran);
//		double amount2 = 3000;
//		LocalDate Date2 = LocalDate.parse("2020-09-10");
//		Transaction tran2 = new Transaction("SEND",Date2,wallet1,amount2,"String");
//		transactionService.addTransaction(tran2);
//		double amount3 = 3000;
//		LocalDate Date3 = LocalDate.parse("2020-09-11");
//		Transaction tran3 = new Transaction("RECEIVE",Date3,wallet1,amount3,"String");
//		transactionService.addTransaction(tran3);
//		CustomerDTO customer2 = walletService.createAccount("Deepan Chakravarthy", "9840091435", new BigDecimal(10000), "Deepan@2000");
//		Wallet wallet2 = WalletUtils.convertToWallet(customer2.getWalletDto());
//		double amount4= 3000;
//		LocalDate Date4 = LocalDate.parse("2020-10-11");
//		Transaction tran4 = new Transaction("RECEIVE",Date4,wallet2,amount4,"String");
//		transactionService.addTransaction(tran4);
//		LocalDate from = LocalDate.parse("2020-07-05");
//		LocalDate to = LocalDate.parse("2020-12-01");
//		LocalDate from1 = LocalDate.parse("2020-12-01");
//		LocalDate to1 = LocalDate.parse("2020-07-05");
//		List<TransactionDTO> tran5 = transactionService.viewTransactionsByDate(from, to);
//		assertNotNull(tran5);
//		assertDoesNotThrow(() -> transactionService.viewTransactionsByDate(from, to));
//		assertThrows(InvalidInputException.class, () -> transactionService.viewTransactionsByDate(from1, to1));
//		logger.info("testViewTransactionByDate() is executed");
//	}

}
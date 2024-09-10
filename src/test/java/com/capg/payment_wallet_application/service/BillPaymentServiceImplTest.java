package com.capg.payment_wallet_application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.payment_wallet_application.beans.BillPayment;
import com.capg.payment_wallet_application.beans.BillType;
import com.capg.payment_wallet_application.beans.Wallet;
import com.capg.payment_wallet_application.dto.BillPaymentDTO;
import com.capg.payment_wallet_application.dto.CustomerDTO;
import com.capg.payment_wallet_application.exception.InsufficientBalanceException;
import com.capg.payment_wallet_application.exception.InvalidInputException;
import com.capg.payment_wallet_application.util.WalletUtils;

@Disabled
@SpringBootTest
class BillPaymentServiceImplTest {
	
//	@Autowired
//	private BillPaymentServiceImpl billServiceImpl;
//	
//	@Autowired
//    private WalletServiceImpl walletService;
//	
//	final Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//    @Test
//	void testAddBillPayment() {
//    	logger.info("testAddBillPayment() is intiated");
//    	BigDecimal balance = new BigDecimal(2000);
//    	CustomerDTO customer = walletService.createAccount("DharaniyaShree","9952068278",balance,"Dharaniya@2000");
//    	Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		LocalDate date = LocalDate.parse("2000-03-11");
//		double amount = 1000;
//		double amount1 = 3000;
//		
//		BillPayment payment = new BillPayment(wallet,BillType.DTH,amount,date);
//		BillPaymentDTO billPayment = billServiceImpl.addBillPayment(payment);
//		BigDecimal updatedAmount = BigDecimal.valueOf(amount);
//		BigDecimal updatedBalance = balance.subtract(updatedAmount);
//		assertEquals(updatedBalance,billPayment.getWalletDto().getBalance());
//	    assertNotNull(billPayment);
//	    
//	    BillPayment payment1 = new BillPayment(wallet,BillType.DTH,amount1,date);
//	    assertThrows(InsufficientBalanceException.class,()->billServiceImpl.addBillPayment(payment1));
//	    logger.info("testAddBillPayment() is executed");
//	}
//
//	@Test
//	void testViewBillPayment() {
//		logger.info("testViewBillPayment() is intiated");
//		BigDecimal balance = new BigDecimal(2000);
//		CustomerDTO customer = walletService.createAccount("DharaniyaShree","9952068286",balance,"Dharaniya@2000");
//    	Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		LocalDate date = LocalDate.parse("2000-03-11");
//		double amount = 1000;
//		BillPayment payment = new BillPayment(wallet,BillType.DTH,amount,date);
//		BillPaymentDTO billPayment = billServiceImpl.addBillPayment(payment);
//		int billId = billPayment.getBillId();
//		BillPaymentDTO billPayment1 = billServiceImpl.viewBillPayment(billId);
//		assertEquals(date,billPayment1.getPaymentDate());
//		
//		int billId1=340;
//		assertThrows(InvalidInputException.class,()->billServiceImpl.viewBillPayment(billId1));
//		logger.info("testViewBillPayment() is executed");
//				
//	}
}

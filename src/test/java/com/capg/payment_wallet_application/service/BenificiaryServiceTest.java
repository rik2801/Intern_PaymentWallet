package com.capg.payment_wallet_application.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.TransactionSystemException;

import com.capg.payment_wallet_application.beans.BeneficiaryDetails;
import com.capg.payment_wallet_application.beans.Wallet;
import com.capg.payment_wallet_application.dto.BeneficiaryDetailsDTO;
import com.capg.payment_wallet_application.dto.CustomerDTO;
import com.capg.payment_wallet_application.exception.InvalidInputException;
import com.capg.payment_wallet_application.exception.WalletNotFoundException;
import com.capg.payment_wallet_application.util.WalletUtils;

@Disabled
@SpringBootTest
class BenificiaryServiceTest {

//	@Autowired
//	private BeneficiaryService beneficiaryService;
//	
//	@Autowired
//	private WalletServiceImpl walletService;
//	
//	final Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	@Test
//	void testAddBeneficiary() {
//		logger.info("testAddBeneficiary() is intiated");
//		CustomerDTO customer = walletService.createAccount("Mummadi madhuri", "9440207619", new BigDecimal(1000), "Madhuri@2000");
//		Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		String name = "Ravi";
//		String name1 = "Suresh";
//		String name2 ="Sathish2";
//		String mobileNumber = "9875623456";
//		String mobileNumber2 = "9445891860566";
//
//		BeneficiaryDetails beneficiary = new BeneficiaryDetails(name, mobileNumber);
//		beneficiary.setWallet(wallet);
//		BeneficiaryDetailsDTO beneficiaryDetails = beneficiaryService.addBeneficiary(beneficiary);
//		assertNotNull(beneficiaryDetails);
//		assertEquals(mobileNumber, beneficiaryDetails.getMobileNo());
//		assertDoesNotThrow(() -> beneficiaryService.addBeneficiary(beneficiary));
//
//		BeneficiaryDetails beneficiary2 = new BeneficiaryDetails(name1, mobileNumber2);
//		beneficiary2.setWallet(wallet);
//		assertThrows(TransactionSystemException.class, () -> beneficiaryService.addBeneficiary(beneficiary2));
//		BeneficiaryDetails beneficiary3 = new BeneficiaryDetails(name2, mobileNumber);
//		beneficiary3.setWallet(wallet);
//		assertThrows(TransactionSystemException.class, () -> beneficiaryService.addBeneficiary(beneficiary3));
//		logger.info("testAddBenificiary() is executed");
//		
//	}
//
//	@Test
//	void testUpdateBeneficiary() {
//		logger.info("testUpdateBeneficiary() is intiated");
//		CustomerDTO customer = walletService.createAccount("Mummadi Madhuri","9440207615",new BigDecimal(1000),"Madhuri@2000");
//		Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		
//		 String name = "Ravi",name1="Suresh12";
//		 String mobileNumber ="9875623456",mobileNumber2="987574754a";
//		 
//		BeneficiaryDetails beneficiary = new BeneficiaryDetails(name,mobileNumber);
//		beneficiary.setWallet(wallet);
//		BeneficiaryDetailsDTO beneficiaryDetails = beneficiaryService.updateBeneficiary(beneficiary);
//		assertEquals(name, beneficiaryDetails.getName());
//		assertNotNull(beneficiary);
//		assertDoesNotThrow(()->beneficiaryService.updateBeneficiary(beneficiary));
//		
//		BeneficiaryDetails beneficiary1 = new BeneficiaryDetails(name1,mobileNumber);
//		assertThrows(TransactionSystemException.class, () -> beneficiaryService.updateBeneficiary(beneficiary1));
//		BeneficiaryDetails beneficiary2 = new BeneficiaryDetails(name,mobileNumber2);
//		assertThrows(TransactionSystemException.class, () -> beneficiaryService.updateBeneficiary(beneficiary2));
//		logger.info("testUpdateBeneficiary() is executed");
//	}
//
//	@Test
//	void testDeleteBenificiary() {
//		logger.info("testDeleteBenificiary() is intiated");
//		CustomerDTO customer = walletService.createAccount("Mummadi Madhuri","9440207603",new BigDecimal(1000),"Madhuri@2000");
//		Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		
//		String name = "Ravi";
//		String mobileNumber = "9875623456";
//
//		BeneficiaryDetails beneficiary = new BeneficiaryDetails(name,mobileNumber);
//		beneficiary.setWallet(wallet);
//		String response = beneficiaryService.deleteBeneficiary(beneficiary);
//		assertEquals("Beneficiary Details is Deleted", response);
//
//		BeneficiaryDetails beneficiary2 = new BeneficiaryDetails();
//		assertThrows(InvalidDataAccessApiUsageException.class,
//				() -> beneficiaryService.deleteBeneficiary(beneficiary2));
//		logger.info("testDeleteBenificiary() is executed");
//	}
//
//	@Test
//	void testViewBeneficiary() {
//		logger.info("testViewBeneficiary() is intiated");
//		CustomerDTO customer = walletService.createAccount("Mummadi Madhuri","9440207605",new BigDecimal(1000),"Madhuri@2000");
//		Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		BeneficiaryDetails beneficiary = new BeneficiaryDetails("Deepan","9360043198");
//		beneficiary.setWallet(wallet);
//		BeneficiaryDetailsDTO beneficiary1 = beneficiaryService.addBeneficiary(beneficiary);
//		String mobileNumber = beneficiary1.getMobileNo();
//		BeneficiaryDetailsDTO beneficiary2 = beneficiaryService.viewBeneficiary(mobileNumber); 
//		assertNotNull(beneficiary2);
//		assertEquals(beneficiary1.getMobileNo(),beneficiary2.getMobileNo());
//		
//		String mobileNumber1 = "9842291860";
//		String mobileNumber2="984229186a";
//		
//		assertThrows(InvalidInputException.class,()->beneficiaryService.viewBeneficiary(mobileNumber1));
//		assertThrows(InvalidInputException.class,()->beneficiaryService.viewBeneficiary(mobileNumber2));
//		logger.info("testViewBeneficiary() is executed");
//	}
//
//
//	@Test
//	void testViewAllBeneficiary() {
//		logger.info("testViewAllBeneficiary() is intiated");
//		CustomerDTO customer = walletService.createAccount("Mummadi Madhuri","9440207561",new BigDecimal(1000),"Madhuri@2000");
//		Wallet wallet = WalletUtils.convertToWallet(customer.getWalletDto());
//		BeneficiaryDetails beneficiary = new BeneficiaryDetails("Maran","7854356789");
//		beneficiary.setWallet(wallet);
//		BeneficiaryDetails beneficiary1 = new BeneficiaryDetails("Mara","7854356788");
//		beneficiary1.setWallet(wallet);
//		BeneficiaryDetailsDTO beneficiary2 =beneficiaryService.addBeneficiary(beneficiary);
//		int walletId = beneficiary2.getWalletDto().getWalletId();
//		int walletId1 =1000;
//		List<BeneficiaryDetailsDTO> beneficiaryDetails = beneficiaryService.viewAllBeneficiary(walletId);
//		assertNotNull(beneficiaryDetails);
//		assertThrows(WalletNotFoundException.class,()->beneficiaryService.viewAllBeneficiary(walletId1));
//		logger.info("testViewAllBeneficiary() is executed");
//	}
}

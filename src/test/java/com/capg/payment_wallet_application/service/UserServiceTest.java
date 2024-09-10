package com.capg.payment_wallet_application.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.payment_wallet_application.dto.CustomerDTO;
import com.capg.payment_wallet_application.exception.InvalidInputException;

@Disabled
@SpringBootTest
class UserServiceTest {
	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private WalletServiceImpl walletService;
//	
//	final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Test
//	void testValidateLogin() {
//		logger.info("testValidateLogin() is intiated");
//		CustomerDTO customer = walletService.createAccount("RishiKiran","9555532631",new BigDecimal(1000),"Rishi@2000");
//		CustomerDTO customer1 = userService.validateLogin(customer.getMobileNo(),"Rishi@2000");
//		assertNotNull(customer);
//		assertEquals(customer.getName(),customer1.getName());
//	    String mobileNo="8887685851";
//	    String password="satheesh2000";
//	    assertThrows(InvalidInputException.class,()->userService.validateLogin(mobileNo,password));
//	    logger.info("testValidateLogin() is executed");
//	}

}

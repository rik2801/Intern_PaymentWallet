
/* Author: Dharaniya Shree.T
*  Date: 07-04-2021
*  Description: This is Bill Payment Controller Layer
*/

package com.capg.payment_wallet_application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.payment_wallet_application.beans.BillPayment;
import com.capg.payment_wallet_application.dto.BillPaymentDTO;
import com.capg.payment_wallet_application.service.IBillPaymentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pwa/bill-payment")
public class BillPaymentController {

	@Autowired
	private IBillPaymentService billService;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	/* Author: Dharaniya Shree.T
	*  Description: This method adds payment 
	*  Input Params: BillPayment
	*  Return value: BillPaymentDTO object
	*/
	@PutMapping(value = "/add-bill", consumes = "application/json")
	public BillPaymentDTO addBillPayment(@RequestBody BillPayment payment) {
		logger.info("BillPayment is added sucessfully");
		return billService.addBillPayment(payment);
	}
	
	/* Author: Dharaniya Shree.T
	*  Description: This method adds payment 
	*  Input Params: int
	*  Return value: BillPaymentDTO object
	*/
	@GetMapping(value = "/view", produces = "application/json")
	public BillPaymentDTO viewBillPayment(int billId) {
		logger.info("BillPayment is displayed sucessfully through billId");
		return billService.viewBillPayment(billId);
	}
}

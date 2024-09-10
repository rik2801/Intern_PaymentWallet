
/* Author: Dharaniya Shree.T
*  Date: 07-04-2021
*  Description: This is Bill Payment Service Layer
*/

package com.capg.payment_wallet_application.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.payment_wallet_application.beans.BillPayment;
import com.capg.payment_wallet_application.beans.Customer;
import com.capg.payment_wallet_application.beans.Transaction;
import com.capg.payment_wallet_application.beans.Wallet;
import com.capg.payment_wallet_application.dto.BillPaymentDTO;
import com.capg.payment_wallet_application.exception.InsufficientBalanceException;
import com.capg.payment_wallet_application.exception.InvalidInputException;
import com.capg.payment_wallet_application.repo.IBillPaymentRepository;
import com.capg.payment_wallet_application.repo.ITransactionRepository;
import com.capg.payment_wallet_application.repo.WalletRepo;
import com.capg.payment_wallet_application.util.BillPaymentUtil;

@Service
public class BillPaymentServiceImpl implements IBillPaymentService {

	@Autowired
	private IBillPaymentRepository billRepo;
	
	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private ITransactionRepository transactionRepo;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/* Author: Dharaniya Shree.T
	*  Description: This method adds payment 
	*  Input Params: BillPayment
	*  Return value: BillPaymentDTO object
	*/
	@Override
	public BillPaymentDTO addBillPayment(BillPayment payment) {
		logger.info("addBillPayment() is get intiated");
		BigDecimal currentBalance = payment.getWallet().getBalance();
		BigDecimal amount = (BigDecimal.valueOf(payment.getAmount()));
		if (amount.compareTo(currentBalance) <= 0) {
			currentBalance = currentBalance.subtract(amount);
			Wallet wallet = payment.getWallet();
			wallet.setBalance(currentBalance);
			payment.setWallet(wallet);
			Customer customer = walletRepo.findByWalletId(wallet.getWalletId());
			customer.setWallet(wallet);
			walletRepo.save(customer);
			logger.info("addBillPayment() is get executed");
			Transaction transaction = new Transaction("SEND",LocalDate.now(),wallet,payment.getAmount(),payment.getBillType().toString());
			transactionRepo.save(transaction);
			return BillPaymentUtil.convertToBillPaymentDto(billRepo.save(payment));
		} else {
			throw new InsufficientBalanceException("Balance of wallet is not Sufficient to do Transaction");
		}
	}
	
	/* Author: Dharaniya Shree.T
	*  Description: This method adds payment 
	*  Input Params: int
	*  Return value: BillPaymentDTO object
	*/
	@Override
	public BillPaymentDTO viewBillPayment(int billId) {
		logger.info("viewBillPayment() is get intiated");
		BillPayment payment = billRepo.findById(billId).orElse(null);
		if (payment == null) {
			throw new InvalidInputException("Wrong Credentials");
		} 
		logger.info("viewBillPayment() is get executed");
	     return BillPaymentUtil.convertToBillPaymentDto(payment);
		}
}

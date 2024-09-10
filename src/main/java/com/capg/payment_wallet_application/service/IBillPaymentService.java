package com.capg.payment_wallet_application.service;

import com.capg.payment_wallet_application.beans.BillPayment;
import com.capg.payment_wallet_application.dto.BillPaymentDTO;

public interface IBillPaymentService {

	public BillPaymentDTO addBillPayment(BillPayment payment);

	public BillPaymentDTO viewBillPayment(int billId);
}

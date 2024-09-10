package com.capg.payment_wallet_application.exception;

public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}

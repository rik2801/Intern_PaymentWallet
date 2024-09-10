package com.capg.payment_wallet_application.exception;

public class WalletNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WalletNotFoundException(String msg) {

		super(msg);

	}

}
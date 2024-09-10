package com.capg.payment_wallet_application.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/*
 * Entity Name              : WalletDTO
 * Author                   : Arun Kumar M
 * Implementation Start Date: 2021-04-01
 * implementation End Date  : 2021-04-02
 * */
@Component
public class WalletDTO {

	private int walletId;
	private BigDecimal balance;

	public WalletDTO() {
		super();
	}

	public WalletDTO(BigDecimal amount) {
		super();
		this.balance = amount;
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", balance=" + balance + "]";
	}

}

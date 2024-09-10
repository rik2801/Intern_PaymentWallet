package com.capg.payment_wallet_application.beans;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;

/*
 * Entity Name              : Wallet
 * Author                   : Arun Kumar M
 * Implementation Start Date: 2021-04-01
 * implementation End Date  : 2021-04-02
 * Used Annotation          : @Entity,@Id(primary key),@GeneratedValue(auto generation),DecimalMin
 * validation               : Bean validation is enabled
 * */
@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int walletId;

	//Bean validation to check if the balance is atleast 1.0
	@DecimalMin(value = "1.0", message = "Balance must be atleast 1.0")
	private BigDecimal balance;

	public Wallet() {
		super();
	}

	public Wallet(BigDecimal amount) {
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

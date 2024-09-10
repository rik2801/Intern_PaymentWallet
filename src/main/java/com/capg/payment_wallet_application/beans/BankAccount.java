package com.capg.payment_wallet_application.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/*
 * Entity Name              : BankAccount
 * Author                   : S. Eswar Bhavish Reddy
 * Implementation Start Date: 2021-04-01
 * implementation End Date  : 2021-04-02
 * Used Annotation          : @Entity, @IdClass, @GeneratedValue, @Pattern, @Size, @DecimalMin, @ManyToOne
 * validation               : Bean validation is done
 * Description				: Entity class for BankAccount
 * */
@Entity
@IdClass(AccountId.class)
public class BankAccount {

	@Id
	private long accountNo;
	
	//Bean validation to check the validity of IFSC code
	@Id
	@Pattern(regexp = "^[A-Z]{4}[0-9]{7}$",
			message = "IFSC code must have 4 alphabets followed by 7 numbers total 11 characters")
	private String ifscCode;

	//Validation for number of characters in bank name
	@Pattern(regexp = "^[A-Za-z ]{3,30}$")
	@Size(max = 30, message = "Bank name should be less than 30 characters")
	private String bankName;
	
	//Validation for minimum balance
	@DecimalMin(value = "1000.0", message = "balance must be a number at least 1000")
	private double balance;
	
	//Many to One relation between BankAccount and Wallet
	@ManyToOne
	private Wallet wallet;

	public BankAccount() {
		super();
	}
	
	//Constructor for BankAccount entity
	public BankAccount(long accountNo,
			@Pattern(regexp = "^[A-Z]{4}[0-9]{7}$", message = "IFSC code must have 4 alphabets followed by 7 numbers total 11 characters") String ifscCode,
			@Pattern(regexp = "^[A-Za-z ]{3,30}$") @Size(max = 30, message = "Bank name should be less than 30 characters") String bankName,
			@DecimalMin(value = "1000.0", message = "balance must be a number at least 1000") double balance,
			Wallet wallet) {
		super();
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.balance = balance;
		this.wallet = wallet;
	}

	public long getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", ifscCode=" + ifscCode + ", bankName=" + bankName
				+ ", balance=" + balance + ", wallet=" + wallet + "]";
	}

}

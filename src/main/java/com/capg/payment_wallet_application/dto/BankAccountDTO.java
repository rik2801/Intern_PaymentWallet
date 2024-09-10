package com.capg.payment_wallet_application.dto;

import org.springframework.stereotype.Component;
/*
 * DTO Name					: BankAccount DTO
 * Author                   : S. Eswar Bhavish Reddy
 * Implementation Start Date: 2021-04-01
 * implementation End Date  : 2021-04-02
 * Description				: DTO Layer for BankAccount
 * */
@Component
public class BankAccountDTO {

	private long accountNo;
	private String ifscCode;
	private String bankName;
	private double balance;
	private WalletDTO walletDto;

	public BankAccountDTO() {
		super();
	}
	
	public BankAccountDTO(long accountNo, String ifscCode, String bankName, double balance, WalletDTO walletDto) {
		super();
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.balance = balance;
		this.walletDto = walletDto;
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

	public WalletDTO getWalletDto() {
		return walletDto;
	}

	public void setWalletDto(WalletDTO wallet) {
		this.walletDto = wallet;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", ifscCode=" + ifscCode + ", bankName=" + bankName
				+ ", balance=" + balance + ", wallet=" + walletDto + "]";
	}
}

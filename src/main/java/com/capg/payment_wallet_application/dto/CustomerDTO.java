package com.capg.payment_wallet_application.dto;

import org.springframework.stereotype.Component;

/*
 * Entity Name              : CustomerDTO
 * Author                   : Arun Kumar M
 * Implementation Start Date: 2021-04-01
 * implementation End Date  : 2021-04-02
 * */
@Component
public class CustomerDTO {

	private String name;
	private String mobileNo;
	private String password;
	private WalletDTO walletDto;

	public CustomerDTO() {
	}

	public CustomerDTO(String name,String mobileNo) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.walletDto = new WalletDTO(); 
	}

	public WalletDTO getWalletDto() {
		return walletDto;
	}

	public void setWalletDto(WalletDTO wallet) {
		this.walletDto = wallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Customer name=" + name + ", mobileNo=" + mobileNo+walletDto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

package com.capg.payment_wallet_application.dto;

import org.springframework.stereotype.Component;

@Component
public class BeneficiaryDetailsDTO {

	private String name;
	private String mobileNo;
	private WalletDTO walletDto;

	public BeneficiaryDetailsDTO() {
		super();
	}

	public BeneficiaryDetailsDTO(String name, String mobileNo) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
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
		return "BenificiaryDetails [ name=" + name + ", mobileNumber="
				+ mobileNo + "]";
	}

	public WalletDTO getWalletDto() {
		return walletDto;
	}

	public void setWalletDto(WalletDTO walletDto) {
		this.walletDto = walletDto;
	}
}

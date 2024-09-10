package com.capg.payment_wallet_application.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

@Entity
public class BeneficiaryDetails {
	
	@Pattern(regexp="^[A-Za-z ]{3,30}$",message = "Name should be in the range of 3 to 30 characters")
	private String name;
	
	@Id
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$",
			message = "Mobile number should have exactly 10 digits and start with a number 6 to 9")
	private String mobileNo;
	
	@ManyToOne
	private Wallet wallet;

	public BeneficiaryDetails() {
		super();
	}

	public BeneficiaryDetails(
			@Pattern(regexp = "^[A-Za-z ]{3,30}$", message = "Name should be in the range of 3 to 30 characters") String name,
			@Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Mobile number should have exactly 10 digits and start with a number 6 to 9") String mobileNo) {
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
		return "BenificiaryDetails [name=" + name + ", mobileNo="
				+ mobileNo + "]";
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
}

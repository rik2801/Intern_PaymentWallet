package com.capg.payment_wallet_application.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

/*
 * Entity Name              : Customer
 * Author                   : Arun Kumar M
 * Implementation Start Date: 2021-04-01
 * implementation End Date  : 2021-04-02
 * Used Annotation          : @Entity,@Id(primary key),@Pattern,@OneToOne
 * validation               : Bean validation is enabled
 * */
@Entity
public class Customer {

	//Bean validation for a valid name
	@Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "Name must only be alphabets and whitespaces from 3 to 20 characters")
	private String name;

	@Id
	//Bean validation for a valid mobile number
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}", message = "Mobile number should be a 10 digit number with first digit from 6 to 9")
	private String mobileNo;

	private String password;

	//One to one mapping with wallet entity
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;

	public Customer() {
	
	}

	public Customer(
			@Pattern(regexp = "^[A-Za-z ]{3,20}$", message = "Name must only be alphabets and whitespaces from 3 to 20 characters") String name,
			@Pattern(regexp = "^[6-9]{1}[0-9]{9}", message = "Mobile number should be a 10 digit number with first digit from 6 to 9") String mobileNo,
			 String password) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.password = password;
		this.wallet = new Wallet();
	}



	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
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

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNo=" + mobileNo + ", password=" + password + ", wallet=" + wallet
				+ "]";
	}

	
}

/*
 * Entity Name              : Transaction
 * Author                   : T.Deepan Chakravarthy
 * Implementation Start Date: 2021-04-01
 * implementation End Date  : 2021-04-02
 * Used Annotation          : @Entity,@Id(primary key),@GeneratedValue(auto generation),@Pattern,@Column,@DateTimeFormat,@NotNull,@DecimalMin,@Size
 * validation               : Bean validation is enabled
 * */
package com.capg.payment_wallet_application.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
 
	//Bean validation to check The constraints of transaction type.
	@Pattern(regexp = "SEND|RECEIVE", message = "Transaction type should be either SEND or RECEIVE")
	private String transactionType;
    
	//Creating a column of name transactionDate in ISO date format.
	@Column(name = "transactiondate")
	@DateTimeFormat(iso = ISO.DATE)
//	@Temporal(TemporalType.DATE)
	private LocalDate transactionDate;

	//ManyToOne mapping is done between transaction and wallet .
	@ManyToOne
	public Wallet wallet;

	//Amount should be atleast 1.0
	@NotNull
	@DecimalMin(value = "1.0", message = "amount should be at least 1.0")
	private double amount;

	@Size(max = 100)
	private String description;

	public Transaction() {
		super();
	}

	public Transaction(String transactionType, LocalDate transactionDate, Wallet wallet, double amount,
			@Size(max = 100) String description) {
		super();
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.wallet = wallet;
		this.amount = amount;
		this.description = description;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionDate=" + transactionDate + ", wallet=" + wallet + ", amount=" + amount
				+ ", description=" + description + "]";
	}

}

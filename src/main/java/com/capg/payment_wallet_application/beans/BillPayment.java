package com.capg.payment_wallet_application.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class BillPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;

	@ManyToOne
	private Wallet wallet;

	@Enumerated(EnumType.STRING)
	private BillType billType;

	@DecimalMin(value = "1.0", message = "amount should be at least 1.0")
	private double amount;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate paymentDate;

	public BillPayment() {
		super();
	}

	public BillPayment(Wallet wallet, BillType billtype, @DecimalMin("1.0") double amount, LocalDate paymentDate) {
		super();
		this.wallet = wallet;
		this.billType = billtype;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public BillType getBillType() {
		return billType;
	}

	public void setBillType(BillType billType) {
		this.billType = billType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "BillPayment [billId=" + billId + ", wallet=" + wallet + ", billtype=" + billType + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + "]";
	}
}

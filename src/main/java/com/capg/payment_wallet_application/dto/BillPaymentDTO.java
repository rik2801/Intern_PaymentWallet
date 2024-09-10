package com.capg.payment_wallet_application.dto;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

import com.capg.payment_wallet_application.beans.BillType;

@Component
public class BillPaymentDTO {

	private int billId;
	private WalletDTO walletDto;
	private BillType billType;
	private double amount;
	private LocalDate paymentDate;

	public BillPaymentDTO() {

	}

	public BillPaymentDTO(int billId, WalletDTO walletDto, BillType billType, double amount, LocalDate paymentDate) {
		super();
		this.billId = billId;
		this.walletDto = walletDto;
		this.billType = billType;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public WalletDTO getWalletDto() {
		return walletDto;
	}

	public void setWalletDto(WalletDTO wallet) {
		this.walletDto = wallet;
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
		return "BillPaymentDTO [billId=" + billId + ", wallet=" + walletDto + ", billType=" + billType + ", amount="
				+ amount + ", paymentDate=" + paymentDate + "]";
	}
}

package com.capg.payment_wallet_application.beans;

import java.io.Serializable;
/*
 * Entity Name              : AccountId
 * Author                   : S. Eswar Bhavish Reddy
 * Implementation Start Date: 2021-04-01
 * Implementation End Date  : 2021-04-02
 * Description				: Composite key for BankAccount entity class
 * */
public class AccountId implements Serializable{

	private static final long serialVersionUID = 1L;

	private long accountNo;

	private String ifscCode;

	public AccountId() {
		super();
	}
	
	public AccountId(long accountNo, String ifscCode) {
		super();
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNo ^ (accountNo >>> 32));
		result = prime * result + ((ifscCode == null) ? 0 : ifscCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountId other = (AccountId) obj;
		if (accountNo != other.accountNo)
			return false;
		if (ifscCode == null) {
			if (other.ifscCode != null)
				return false;
		} else if (!ifscCode.equals(other.ifscCode))
			return false;
		return true;
	}
	
	
}

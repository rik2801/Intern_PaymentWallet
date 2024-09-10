package com.capg.payment_wallet_application.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.payment_wallet_application.beans.BankAccount;
import com.capg.payment_wallet_application.dto.BankAccountDTO;
/*
 * Utility Name			    : AccountUtils
 * Author                   : S. Eswar Bhavish Reddy
 * Implementation Start Date: 2021-04-05
 * implementation End Date  : 2021-04-06
 * Description				: Utilities Required for Account 
 * */
public class AccountUtils {

	private AccountUtils() {

	}

	public static List<BankAccountDTO> convertToBankAccountDtoList(List<BankAccount> list) {
		List<BankAccountDTO> dtoList = new ArrayList<>();
		for (BankAccount BankAccount : list)
			dtoList.add(convertToBankAccountDto(BankAccount));
		return dtoList;
	}

	public static BankAccount convertToBankAccount(BankAccountDTO dto) {
		BankAccount bankAcc = new BankAccount();
		bankAcc.setAccountNo(dto.getAccountNo());
		bankAcc.setBalance(dto.getBalance());
		bankAcc.setBankName(dto.getBankName());
		bankAcc.setIfscCode(dto.getIfscCode());
		bankAcc.setWallet(WalletUtils.convertToWallet(dto.getWalletDto()));
		return bankAcc;
	}

	public static BankAccountDTO convertToBankAccountDto(BankAccount bankAcc) {
		BankAccountDTO dto = new BankAccountDTO();

		dto.setAccountNo(bankAcc.getAccountNo());
		dto.setBalance(bankAcc.getBalance());
		dto.setBankName(bankAcc.getBankName());
		dto.setIfscCode(bankAcc.getIfscCode());
		dto.setWalletDto(WalletUtils.convertToWalletDto(bankAcc.getWallet()));

		return dto;
	}
}

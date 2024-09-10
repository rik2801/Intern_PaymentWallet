package com.capg.payment_wallet_application.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.payment_wallet_application.beans.BeneficiaryDetails;
import com.capg.payment_wallet_application.dto.BeneficiaryDetailsDTO;


public class BeneficiaryDetailsUtils {

	private BeneficiaryDetailsUtils() {

	}

	public static List<BeneficiaryDetailsDTO> convertToBeneficiaryDetailsDtoList(List<BeneficiaryDetails> list) {
		List<BeneficiaryDetailsDTO> dtolist = new ArrayList<>();
		for (BeneficiaryDetails BeneficiaryDetails : list)
			dtolist.add(convertToBeneficiaryDetailsDto(BeneficiaryDetails));
		return dtolist;
	}

	public static BeneficiaryDetails convertToBeneficiaryDetails(BeneficiaryDetailsDTO dto) {
		BeneficiaryDetails beneficiarydetails = new BeneficiaryDetails();

		beneficiarydetails.setMobileNo(dto.getMobileNo());
		beneficiarydetails.setName(dto.getName());
		beneficiarydetails.setWallet(WalletUtils.convertToWallet(dto.getWalletDto()));
		return beneficiarydetails;

	}

	public static BeneficiaryDetailsDTO convertToBeneficiaryDetailsDto(BeneficiaryDetails beneficiarydetails) {
		BeneficiaryDetailsDTO beneficiarydetailsDTO = new BeneficiaryDetailsDTO();

		beneficiarydetailsDTO.setMobileNo(beneficiarydetails.getMobileNo());
		beneficiarydetailsDTO.setName(beneficiarydetails.getName());
		beneficiarydetailsDTO.setWalletDto(WalletUtils.convertToWalletDto(beneficiarydetails.getWallet()));
		return beneficiarydetailsDTO;

	}
}

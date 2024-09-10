package com.capg.payment_wallet_application.service;

import java.util.List;

import com.capg.payment_wallet_application.beans.BeneficiaryDetails;
import com.capg.payment_wallet_application.dto.BeneficiaryDetailsDTO;



public interface IBeneficiaryService {

	public BeneficiaryDetailsDTO addBeneficiary(BeneficiaryDetails bd);

	public BeneficiaryDetailsDTO updateBeneficiary(BeneficiaryDetails bd);

	public String deleteBeneficiary(BeneficiaryDetails bd);

	public BeneficiaryDetailsDTO viewBeneficiary(String mobileNo);

	public List<BeneficiaryDetailsDTO> viewAllBeneficiary(int walletId);

}

package com.capg.payment_wallet_application.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.payment_wallet_application.beans.BeneficiaryDetails;

@Repository
public interface IBeneficiaryRepository extends JpaRepository<BeneficiaryDetails, String> {

	@Query("select bd from BeneficiaryDetails bd where bd.wallet.walletId=:walletId")
	public List<BeneficiaryDetails> viewAllBeneficiary(@Param("walletId") int walletId);

	public Optional<BeneficiaryDetails> findById(String mobileNumber);
}

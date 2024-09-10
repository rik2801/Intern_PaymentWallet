package com.capg.payment_wallet_application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.payment_wallet_application.beans.AccountId;
import com.capg.payment_wallet_application.beans.BankAccount;
/*
 * Repository Name          : IAccountRepository
 * Author                   : S. Eswar Bhavish Reddy
 * Implementation Start Date: 2021-04-05
 * implementation End Date  : 2021-04-06
 * Used Annotation          : @Repository,@Query,@Param 
 * JpaRepository            : JpaRepository is extended
 * Description				: Repository Layer for IAccountRepository interface
 * */
@Repository
public interface IAccountRepository extends JpaRepository<BankAccount, AccountId> {
	// JPQL query to get bankAccount object using its wallet id
	@Query("select bacc from BankAccount bacc where bacc.wallet.walletId=:walletId")
	public List<BankAccount> findByWalletId(@Param("walletId") int walletId);

}

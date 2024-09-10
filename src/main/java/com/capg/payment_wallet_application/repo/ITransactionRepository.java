/*
 * Repository Name          : ITransactionRepoitory
 * Author                   : T.Deepan Chakravarthy
 * Implementation Start Date: 2021-04-05
 * implementation End Date  : 2021-04-06
 * Used Annotation          : @Repository,@Query 
 * JpaRepository            : JpaRepository is extended
 * */
package com.capg.payment_wallet_application.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.capg.payment_wallet_application.beans.Transaction;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {

	// Jpql Query is written to view all transaction of the given wallet id
	@Query("select t from Transaction t where t.wallet.walletId = :walletId")
	public List<Transaction> viewAllTransactions(@Param(value = "walletId") int walletId);

	// Jpql Query is written to view all transaction between two dates
	@Query("SELECT t FROM Transaction t WHERE t.transactionDate BETWEEN :from AND :to")
	public List<Transaction> viewTransactionsByDate(
			@Param(value = "from") @DateTimeFormat(iso = ISO.DATE) LocalDate from,
			@Param(value = "to") @DateTimeFormat(iso = ISO.DATE) LocalDate to);

	// Jpql Query is written to view all transaction of the given type
	@Query("select t from Transaction t where t.transactionType = :type")
	public List<Transaction> viewAllTransactions(@Param(value = "type") String type);

}

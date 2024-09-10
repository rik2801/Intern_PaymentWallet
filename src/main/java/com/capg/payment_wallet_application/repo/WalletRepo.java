package com.capg.payment_wallet_application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.payment_wallet_application.beans.Customer;

/*
 * Repository Name          : WalletRepo
 * Author                   : Arun Kumar M
 * Implementation Start Date: 2021-04-05
 * implementation End Date  : 2021-04-06
 * Used Annotation          : @Repository,@Query,@Param 
 * JpaRepository            : JpaRepository is extended
 * */
@Repository
public interface WalletRepo extends JpaRepository<Customer, String> {

	// JPQL query to get the customer object using its mobile no
	@Query("select c from Customer c where c.mobileNo = :mobileNo")
	public Customer findOne(@Param(value = "mobileNo") String mobileNo);

	// JPQL query to get the list of all the customers
	@Query("select c from Customer c")
	public List<Customer> getList();

	// JPQL query to get a customer object based on its wallet id
	@Query("select c from Customer c where c.wallet.walletId = :walletId")
	public Customer findByWalletId(@Param(value = "walletId") int walletId);
}

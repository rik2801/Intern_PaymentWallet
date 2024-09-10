package com.capg.payment_wallet_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.payment_wallet_application.beans.Customer;

@Repository
public interface IUserRepo extends JpaRepository<Customer, String> {

	@Query("select c from Customer c where c.mobileNo = :mobileNumber and c.password = :password")
	public Customer validateLogin(@Param(value = "mobileNumber") String mobileNumber,
			@Param(value = "password") String password);
}

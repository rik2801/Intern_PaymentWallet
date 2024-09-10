package com.capg.payment_wallet_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.payment_wallet_application.beans.BillPayment;

@Repository
public interface IBillPaymentRepository extends JpaRepository<BillPayment, Integer> {

}

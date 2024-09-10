package com.capg.payment_wallet_application.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.payment_wallet_application.beans.Transaction;
import com.capg.payment_wallet_application.dto.TransactionDTO;

public interface ITransactionService {

	public TransactionDTO addTransaction(Transaction tran);

	public List<TransactionDTO> viewAllTransactions(int walletId);

	public List<TransactionDTO> viewAllTransactions(String type);

	public List<TransactionDTO> viewTransactionsByDate(LocalDate from, LocalDate to);
}

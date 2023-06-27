package com.wh.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.wh.entities.Transaction;
import com.wh.repositories.TransactionRepository;

public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return repository.save(transaction);
	}

}

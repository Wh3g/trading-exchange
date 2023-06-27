package com.wh.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.entities.Transaction;
import com.wh.repositories.TransactionRepository;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

	@InjectMocks
	private TransactionServiceImpl service;
	@Mock
	private TransactionRepository repository;
	
	@Test
	public void testCreateTransaction() {
		Transaction transaction = mock(Transaction.class);
		
		service.createTransaction(transaction);
		
		verify(repository, times(1)).save(transaction);
	}
}

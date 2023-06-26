package com.wh.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.entities.Exchange;
import com.wh.repositories.ExchangeRepository;

@ExtendWith(MockitoExtension.class)
public class ExchangeServiceImplTest {

	@InjectMocks
	ExchangeServiceImpl service;
	
	@Mock
	ExchangeRepository repository;
	
	@Test
	public void testCreateExchange() {
		Exchange exchange = mock(Exchange.class);
		
		service.createExchange(exchange);
		
		verify(repository, times(1)).save(exchange);
	}
}

package com.wh.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.entities.OrderBook;
import com.wh.repositories.OrderBookRepository;

@ExtendWith(MockitoExtension.class)
public class OrderBookServiceImplTest {

	@InjectMocks
	private OrderBookServiceImpl service;
	
	@Mock
	private OrderBookRepository repository;
	
	@Test
	public void testCreateOrderBook() {
		OrderBook orderBook = mock(OrderBook.class);
		service.createOrderBook(orderBook);
		
		verify(repository, times(1)).save(orderBook);
	}
	
	@Test
	public void testGetAllOrderBooks() {
		service.getAllOrderBooks();
		
		verify(repository, times(1)).findAll();
	}
}

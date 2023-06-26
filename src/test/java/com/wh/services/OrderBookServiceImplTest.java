package com.wh.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.entities.Exchange;
import com.wh.entities.OrderBook;
import com.wh.repositories.OrderBookRepository;

@ExtendWith(MockitoExtension.class)
public class OrderBookServiceImplTest {

	@InjectMocks
	private OrderBookServiceImpl service;
	
	@Mock
	private OrderBookRepository repository;
	
	@Mock
	private ExchangeService exchangeService;

	private OrderBook orderBook = mock(OrderBook.class);
	
	@Test
	public void testCreateOrderBook() {
		
		Exchange exchange = mock(Exchange.class);
		
		when(exchangeService.getExchange(exchange.getCode())).thenReturn(Optional.of(exchange));
		
		service.createOrderBook(exchange.getCode(), orderBook);
		
		verify(repository, times(1)).save(orderBook);
	}
	
	@Test
	public void testGetAllOrderBooks() {
		service.getAllOrderBooks();
		
		verify(repository, times(1)).findAll();
	}
	
	@Test
	public void testGetOrderBook() {
		service.getOrderBook(orderBook.getCode());
		
		verify(repository, times(1)).findById(orderBook.getCode());
	}
	
}

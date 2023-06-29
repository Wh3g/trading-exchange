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

import com.wh.entities.Ask;
import com.wh.entities.Bid;
import com.wh.entities.Exchange;
import com.wh.entities.Order;
import com.wh.entities.OrderBook;
import com.wh.entities.Transaction;
import com.wh.repositories.OrderBookRepository;

@ExtendWith(MockitoExtension.class)
public class OrderBookServiceImplTest {

	@InjectMocks
	private OrderBookServiceImpl service;
	
	@Mock
	private OrderBookRepository repository;
	
	@Mock
	private ExchangeService exchangeService;
	
	@Mock
	private TransactionService transactionService;

	private OrderBook orderBook = mock(OrderBook.class);
	private Exchange exchange = mock(Exchange.class);
	
	@Test
	public void testCreateOrderBook() {
		
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
	
	@Test
	public void testGetOrderBooksByExchange() {
		when(exchangeService.getExchange(exchange.getCode())).thenReturn(Optional.of(exchange));
		
		service.getOrderBooksByExchange(exchange.getCode());
		
		verify(repository, times(1)).findByExchange(exchange);
	}
	
	@Test
	public void testCreateTransaction() {
		
		Transaction transaction = mock(Transaction.class);
		
		
		service.createTransaction(transaction);
		verify(transactionService, times(1)).createTransaction(transaction);
	}
	
}

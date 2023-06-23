package com.wh.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wh.entities.OrderBook;
import com.wh.services.OrderBookService;

@ExtendWith(MockitoExtension.class)
public class OrderBookRestControllerTest {

	@InjectMocks
	private OrderBookRestController controller;
	
	@Mock
	private OrderBookService service;
	
	private OrderBook orderBook = mock(OrderBook.class);
	
	@Test
	public void testCreateOrderBook() {
		
		controller.createOrderBook(orderBook);
		
		verify(service, times(1)).createOrderBook(orderBook);
	}
	
	@Test
	public void testCreateOrderBookContent() {
		
		ResponseEntity<OrderBook> actualResult = controller.createOrderBook(orderBook);
		
		assertEquals(HttpStatus.CREATED, actualResult.getStatusCode());
	}
	
	@Test
	public void testGetAllOrderBooks() {
		controller.getAllOrderBooks();
		
		verify(service, times(1)).getAllOrderBooks();
	}
	
	@Test
	public void testGetAllOrderBooksResponse() {
		ResponseEntity<List<OrderBook>> actualResult = controller.getAllOrderBooks();
		
		assertEquals(HttpStatus.OK, actualResult.getStatusCode());
	}
}

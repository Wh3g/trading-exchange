package com.wh.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.wh.entities.OrderBook;
import com.wh.services.OrderBookService;

@RestController
public class OrderBookRestController {

	@Autowired
	private OrderBookService service;
	
	public ResponseEntity<OrderBook> createOrderBook(OrderBook orderBook) {
		OrderBook storedOrderBook = service.createOrderBook(orderBook);
		return new ResponseEntity<OrderBook>(storedOrderBook, HttpStatus.CREATED);
	}

}

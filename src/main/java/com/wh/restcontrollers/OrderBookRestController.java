package com.wh.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wh.entities.OrderBook;
import com.wh.services.OrderBookService;

@RestController
public class OrderBookRestController {

	@Autowired
	private OrderBookService service;
	
	@PostMapping("/exchanges/{exchangeCode}/order-books")
	public ResponseEntity<OrderBook> createOrderBook(@PathVariable("exchangeCode") String exchangeCode, @RequestBody OrderBook orderBook) {
		
		OrderBook storedOrderBook = service.createOrderBook(exchangeCode, orderBook);
		return new ResponseEntity<OrderBook>(storedOrderBook, HttpStatus.CREATED);
	}

	@GetMapping("/order-books")
	public ResponseEntity<List<OrderBook>> getAllOrderBooks() {
		List<OrderBook> list = service.getAllOrderBooks();
		return new ResponseEntity<List<OrderBook>>(list, HttpStatus.OK);
	}

	@GetMapping("/order-books/{code}")
	public Optional<OrderBook> getOrderBook(@PathVariable("code") String code) {
		return service.getOrderBook(code);
	}

	@GetMapping("/exchanges/{exchangeCode}/order-books")
	public ResponseEntity<List<OrderBook>> getOrderBooksByExchange(@PathVariable("exchangeCode") String exchangeCode) {
		List<OrderBook> list = service.getOrderBooksByExchange(exchangeCode);
		return new ResponseEntity<List<OrderBook>>(list, HttpStatus.OK);
	}

}

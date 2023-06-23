package com.wh.services;

import java.util.List;
import java.util.Optional;

import com.wh.entities.OrderBook;

public interface OrderBookService {

	public OrderBook createOrderBook(OrderBook orderBook);
	
	public List<OrderBook> getAllOrderBooks();
	
	public Optional<OrderBook> getOrderBook(String code);
}

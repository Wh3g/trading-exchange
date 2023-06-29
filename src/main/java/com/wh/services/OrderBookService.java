package com.wh.services;

import java.util.List;
import java.util.Optional;

import com.wh.entities.Ask;
import com.wh.entities.Bid;
import com.wh.entities.OrderBook;
import com.wh.entities.Transaction;

public interface OrderBookService {

	public OrderBook createOrderBook(String exchangeCode, OrderBook orderBook);
	
	public List<OrderBook> getAllOrderBooks();
	
	public Optional<OrderBook> getOrderBook(String code);
	
	public List<OrderBook> getOrderBooksByExchange(String exchangeCode);
	
	public Transaction createTransaction(Transaction transaction);
}

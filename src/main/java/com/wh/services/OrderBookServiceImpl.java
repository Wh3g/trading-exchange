package com.wh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.entities.Exchange;
import com.wh.entities.OrderBook;
import com.wh.entities.Transaction;
import com.wh.repositories.OrderBookRepository;

@Service
public class OrderBookServiceImpl implements OrderBookService {

	@Autowired
	private OrderBookRepository repository;
	
	@Autowired
	private ExchangeService exchangeService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Override
	public OrderBook createOrderBook(String exchangeCode, OrderBook orderBook) {
		orderBook.setExchangeCode(exchangeService.getExchange(exchangeCode).get());
		return repository.save(orderBook);
	}

	@Override
	public List<OrderBook> getAllOrderBooks() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<OrderBook> getOrderBook(String code) {
		return repository.findById(code);
	}

	@Override
	public List<OrderBook> getOrderBooksByExchange(String exchangeCode) {
		Exchange exchange = exchangeService.getExchange(exchangeCode).get();
		return repository.findByExchange(exchange);
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionService.createTransaction(transaction);
	}

}

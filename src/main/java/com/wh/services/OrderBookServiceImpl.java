package com.wh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.entities.OrderBook;
import com.wh.repositories.OrderBookRepository;

@Service
public class OrderBookServiceImpl implements OrderBookService {

	@Autowired
	private OrderBookRepository repository;
	
	@Override
	public OrderBook createOrderBook(OrderBook orderBook) {
		// TODO Auto-generated method stub
		return repository.save(orderBook);
	}

	@Override
	public List<OrderBook> getAllOrderBooks() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<OrderBook> getOrderBook(String code) {
		// TODO Auto-generated method stub
		return repository.findById(code);
	}

}

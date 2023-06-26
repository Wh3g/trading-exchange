package com.wh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.entities.Exchange;
import com.wh.repositories.ExchangeRepository;

@Service
public class ExchangeServiceImpl implements ExchangeService {

	@Autowired
	ExchangeRepository repository;
	
	@Override
	public Exchange createExchange(Exchange exchange) {
		return repository.save(exchange);
	}

}

package com.wh.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Exchange> getAllExchanges() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Exchange> getExchange(String code) {
	
		return repository.findById(code);
	}

}

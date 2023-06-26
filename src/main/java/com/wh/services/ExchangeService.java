package com.wh.services;

import java.util.List;
import java.util.Optional;

import com.wh.entities.Exchange;

public interface ExchangeService {
	
	public Exchange createExchange(Exchange exchange);
	
	public List<Exchange> getAllExchanges();
	
	public Optional<Exchange> getExchange(String code);
}

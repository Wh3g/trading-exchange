package com.wh.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wh.entities.Exchange;
import com.wh.services.ExchangeService;

@RestController
public class ExchangeRestController {

	@Autowired
	ExchangeService service;
	
	@PostMapping("/exchanges")
	public ResponseEntity<Exchange> createExchange(@RequestBody Exchange exchange) {
		Exchange storedExchange = service.createExchange(exchange);
		return new ResponseEntity<Exchange>(storedExchange, HttpStatus.CREATED);
	}

}

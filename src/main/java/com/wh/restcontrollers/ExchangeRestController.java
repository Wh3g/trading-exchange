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

	@GetMapping("/exchanges")
	public ResponseEntity<List<Exchange>> getAllExchanges() {
		List<Exchange> exchanges =  service.getAllExchanges();
		return new ResponseEntity<List<Exchange>>(exchanges, HttpStatus.OK);
	}

	@GetMapping("/exchanges/{code}")
	public Optional<Exchange> getExchange(@PathVariable("code") String code) {
		return service.getExchange(code);
	}

}

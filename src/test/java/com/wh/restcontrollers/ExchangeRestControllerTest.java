package com.wh.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wh.entities.Exchange;
import com.wh.services.ExchangeService;

@ExtendWith(MockitoExtension.class)
public class ExchangeRestControllerTest {

	@InjectMocks
	ExchangeRestController controller;
	
	@Mock
	ExchangeService service;
	
	private Exchange exchange = mock(Exchange.class);
	
	@Test
	public void testCreateExchange() {
		
		controller.createExchange(exchange);
		
		verify(service, times(1)).createExchange(exchange);
	}
	
	@Test
	public void testCreateExchangeResponse() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(service.createExchange(exchange)).thenReturn(exchange);
		
		ResponseEntity<Exchange> actualResult = controller.createExchange(exchange);
		
		assertEquals(exchange, actualResult.getBody());
		assertEquals(HttpStatus.CREATED, actualResult.getStatusCode());
	}
	
	@Test
	public void testGetAllExchanges() {
		controller.getAllExchanges();
		
		verify(service, times(1)).getAllExchanges();
	}
	
	@Test
	public void testGetAllExchangesResponse() {
		ResponseEntity<List<Exchange>> actualResult = controller.getAllExchanges();
		
		assertEquals(HttpStatus.OK, actualResult.getStatusCode());
	}
	
	@Test
	public void testGetExchange() {
		controller.getExchange(exchange.getCode());
		
		verify(service, times(1)).getExchange(exchange.getCode());
	}
	
	@Test
	public void testGetExchangeResponse() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(service.getExchange(exchange.getCode())).thenReturn(Optional.of(exchange));
		
		Optional<Exchange> actualResult = controller.getExchange(exchange.getCode());
		
		assertEquals(Optional.of(exchange), actualResult);
	}
}

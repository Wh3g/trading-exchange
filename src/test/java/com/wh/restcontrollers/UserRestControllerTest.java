package com.wh.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.wh.entities.User;
import com.wh.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserRestControllerTest {

	@InjectMocks
	UserRestController controller;
	
	@Mock
	UserService service;
	
	private User user = new User(
			"test@email.com", 
			"johnsmith", 
			"password");
	
	@Test
	public void testCreateUser() {
		controller.createUser(user);
		verify(service, times(1)).createUser(user);
	}
	
	@Test
	public void testCreateUserCode() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(service.createUser(user)).thenReturn(user);
		
		ResponseEntity<User> actualResult = controller.createUser(user);
		
		assertEquals(HttpStatus.CREATED, actualResult.getStatusCode());
	}
	
	@Test
	public void testLogin() {
		controller.login(user.getEmail(), user.getPassword());
		
		verify(service, times(1)).getUser(user.getEmail(), user.getPassword());
	}
	
	@Test
	public void testUpdateUsername() {
		controller.updateUsername(user.getUsername(), user.getEmail());
		
		verify(service, times(1)).updateUsername(user.getUsername(), user.getEmail());
	}
}

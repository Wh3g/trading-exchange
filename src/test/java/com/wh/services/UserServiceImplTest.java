package com.wh.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.entities.User;
import com.wh.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl service;
	
	@Mock
	UserRepository repository;
	
	@Test
	public void testCreateUser() {
		User user = new User(
				"test@email.com", 
				"johnsmith", 
				"password");
		
		service.createUser(user);
		
		verify(repository, times(1)).save(user);
	}
}

package com.wh.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wh.entities.User;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

	private User user = new User(
			"test@email.com", 
			"johnsmith", 
			"password");
	
	@Mock
	UserRepository repository;
	
	@Test
	public void testGetUserByEmailAndPassword() {
	
		when(repository.getUser(user.getEmail(), user.getPassword())).thenReturn(Optional.of(user));
		
		Optional<User> actualResult = repository.getUser(user.getEmail(), user.getPassword());
		
		assertNotNull(actualResult);
	}

}

package com.wh.services;

import static org.mockito.Mockito.mock;
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
	
	private User user = mock(User.class);
	
	@Test
	public void testCreateUser() {
		
		service.createUser(user);
		
		verify(repository, times(1)).save(user);
	}
	
	@Test
	public void testGetUser() {
		
		service.getUser(user.getEmail(), user.getPassword());
		
		verify(repository, times(1)).getUser(user.getEmail(), user.getPassword());
	}
	
	@Test
	public void testUpdateUsername() {
		
		service.updateUsername(user.getUsername(), user.getEmail());
		
		verify(repository, times(1)).updateUsername(user.getUsername(), user.getEmail());
	}
	
	@Test
	public void testUpdatePassword() {
		
		String newPassword = "newPassword";
		
		service.updatePassword(newPassword, user.getEmail(), user.getPassword());
		
		verify(repository, times(1)).updatePassword(newPassword, user.getEmail(), user.getPassword());
	}
	
	@Test
	public void testDeleteUser() {
		
		service.deleteUser(user);
		
		verify(repository, times(1)).delete(user);
	}
}

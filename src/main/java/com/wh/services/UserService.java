package com.wh.services;

import java.util.Optional;

import com.wh.entities.User;

public interface UserService {

	public User createUser(User user);
	
	public Optional<User> getUser(String email, String password);
	
	public void updateUsername(String username, String email);
}
